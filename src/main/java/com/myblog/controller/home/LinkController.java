package com.myblog.controller.home;

import com.myblog.entity.Article;
import com.myblog.entity.Link;
import com.myblog.enums.LinkStatus;
import com.myblog.service.ArticleService;
import com.myblog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Author: stone
 * @Date: 2020/03/25 21:57:51
 * @ClassName: LinkController
 * @Description:
 **/

@Controller
public class LinkController {

	@Autowired
	private LinkService linkService;

	@Autowired
	private ArticleService articleService;

	@RequestMapping("/applyLink")
	public String applyLinkView(Model model) {
		//侧边栏显示
		//获得热评文章
		List<Article> mostCommentArticleList = articleService.listArticleByCommentCount(8);
		model.addAttribute("mostCommentArticleList", mostCommentArticleList);
		return "Home/Page/applyLink";
	}

	@RequestMapping(value = "/applyLinkSubmit", method = {RequestMethod.POST})
	@ResponseBody
	public void applyLinkSubmit(Link link) {
		link.setLinkStatus(LinkStatus.HIDDEN.getValue());
		link.setLinkCreateTime(new Date());
		link.setLinkUpdateTime(new Date());
		linkService.insertLink(link);
	}
}
