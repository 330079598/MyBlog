package com.myblog.controller.home;

import com.github.pagehelper.PageInfo;
import com.myblog.entity.Article;
import com.myblog.enums.ArticleStatus;
import com.myblog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * @Author: stone
 * @Date: 2020/01/13 16:50:14
 * @ClassName: IndexController
 * @Description:
 **/

@Controller
public class IndexController {
	@Autowired
	private ArticleService articleService;

	@Autowired
	private LinkService linkService;

	@Autowired
	private NoticeService noticeService;

	@Autowired
	private TagService tagService;

	@Autowired
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

		return "Home/index";
	}
}
