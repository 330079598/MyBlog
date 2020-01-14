package com.myblog.controller.home;

import com.github.pagehelper.PageInfo;
import com.myblog.entity.*;
import com.myblog.enums.ArticleStatus;
import com.myblog.enums.LinkStatus;
import com.myblog.enums.NoticeStatus;
import com.myblog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: stone
 * @Date: 2020/01/13 16:50:14
 * @ClassName: IndexController
 * @Description:
 **/

@Controller
public class IndexController {
	@Autowired(required = false)
	private ArticleService articleService;

	@Autowired(required = false)
	private LinkService linkService;

	@Autowired(required = false)
	private NoticeService noticeService;

	@Autowired(required = false)
	private TagService tagService;

	@Autowired(required = false)
	private CommentService commentService;

	@RequestMapping(value = {"/","/article"})
	public String index(@RequestParam(required = false,defaultValue = "1") Integer pageIndex,
	                    @RequestParam(required = false,defaultValue = "10") Integer pageSize, Model model){
		HashMap<String,Object> criteria = new HashMap<>(1);
		criteria.put("status", ArticleStatus.PUBLISH.getValue());
		//文章列表
		PageInfo<Article> articleList = articleService.pageArticle(pageIndex, pageSize, criteria);
		model.addAttribute("pageInfo",articleList);

		//公告
		List<Notice> noticeList = noticeService.listNotice(NoticeStatus.NORMAL.getValue());
		model.addAttribute("noticeList",noticeList);

		//友情链接
		List<Link> linkList = linkService.listLink(LinkStatus.NORMAL.getValue());
		model.addAttribute("linkList",linkList);

		//侧边栏显示
		//标签列表显示
		List<Tag> allTagList = tagService.listTag();
		model.addAttribute("allTagList", allTagList);
		//最新评论
		List<Comment> recentCommentList = commentService.listRecentComment(10);
		model.addAttribute("recentCommentList", recentCommentList);
		model.addAttribute("pageUrlPrefix", "/article?pageIndex");
		return "Home/index";
	}
}
