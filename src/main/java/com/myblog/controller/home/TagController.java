package com.myblog.controller.home;

import com.github.pagehelper.PageInfo;
import com.myblog.entity.Article;
import com.myblog.entity.Tag;
import com.myblog.enums.ArticleStatus;
import com.myblog.service.ArticleService;
import com.myblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: stone
 * @Date: 2020/03/14 23:16:51
 * @ClassName: TagController
 * @Description:
 **/

@Controller
public class TagController {

	@Autowired
	private TagService tagService;

	@Autowired
	private ArticleService articleService;

	/**
	 * @Author: stone
	 * @Param: TagId
	 * @return:
	 * @Description:
	 **/
	@RequestMapping("/tag/{tagId}")
	public String getArticleListByTag(@PathVariable("tagId") Integer tagId,
	                                  @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
	                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize,
	                                  Model model) {
		//该标签信息
		Tag tag = tagService.getTagById(tagId);
		if (tag == null) {
			return "redirext:/404";
		}
		model.addAttribute("tag", tag);

		//文章列表
		HashMap<String, Object> criteria = new HashMap<>(2);
		criteria.put("tagId", tagId);
		criteria.put("status", ArticleStatus.PUBLISH.getValue());
		PageInfo<Article> articlePageInfo = articleService.pageArticle(pageIndex, pageSize, criteria);
		model.addAttribute("pageInfo", articlePageInfo);

		//侧边栏显示
		//标签列表显示
		List<Tag> allTagList = tagService.listTag();
		model.addAttribute("allTagList", allTagList);

		//获得随机文章
		List<Article> randomArticleList = articleService.listRandomArticle(8);
		model.addAttribute("randomArticleList", randomArticleList);

		//获得热评文章
		List<Article> mostCommentArticleList = articleService.listArticleByCommentCount(8);
		model.addAttribute("mostCommenArticleList", mostCommentArticleList);
		model.addAttribute("pageUrlPrefix", "/tag?pageIndex");

		return "Home/Page/articleListByTag";
	}
}
