package com.myblog.controller.admin;

import com.myblog.entity.Article;
import com.myblog.entity.Comment;
import com.myblog.entity.User;
import com.myblog.service.ArticleService;
import com.myblog.service.CommentService;
import com.myblog.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.myblog.util.MyUtils.getIpAddr;

/**
 * @Author: stone
 * @Date: 2020/01/11 22:16:04
 * @ClassName: AdminController
 * @Description:
 **/

@Controller
public class AdminController {

	@Autowired(required = false)
	private UserService userService;

	@Autowired(required = false)
	private ArticleService articleService;

	@Autowired(required = false)
	private CommentService commentService;

	/**
	 * 后台首页
	 */
	@RequestMapping("/admin")
	public String index(Model model) {
		//文章列表
		List<Article> articleList = articleService.listRecentArticle(5);
		model.addAttribute("articleList", articleList);
		//评论列表
		List<Comment> commentList = commentService.listRecentComment(5);
		model.addAttribute("commentList", commentList);
		return "Admin/index";
	}

	/**
	 * 登录页面显示
	 */
	@RequestMapping("/login")
	public String loginPage() {
		return "Admin/login";
	}

	/**
	 * 验证登录
	 */
	@RequestMapping(value = "/loginVerify", method = RequestMethod.POST)
	@ResponseBody
	public String loginVerify(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rememberme = request.getParameter("rememberme");
		User user = userService.getUserByNameOrEmail(username);
		if (user == null) {
			map.put("code", 0);
			map.put("msg", "用户名无效！");
		} else if (!user.getUserPass().equals(password)) {
			map.put("code", 0);
			map.put("msg", "密码错误！");
		} else {
			//登录成功
			map.put("code", 1);
			map.put("msg", "");
			//添加session
			request.getSession().setAttribute("user", user);
			//添加cookie
			if (rememberme != null) {
				//创建两个Cookie对象
				Cookie nameCookie = new Cookie("username", username);
				//设置Cookie的有效期为3天
				nameCookie.setMaxAge(60 * 60 * 24 * 3);
				Cookie pwdCookie = new Cookie("password", password);
				pwdCookie.setMaxAge(60 * 60 * 24 * 3);
				response.addCookie(nameCookie);
				response.addCookie(pwdCookie);
			}
			user.setUserLastLoginTime(new Date());
			user.setUserLastLoginIp(getIpAddr(request));
			userService.updateUser(user);

		}
		String result = new JSONObject(map).toString();
		return result;
	}

	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/admin/logout")
	public String logout(HttpSession session){
		session.removeAttribute("user");
		session.invalidate();
		return "redirect:/login";
	}
}
