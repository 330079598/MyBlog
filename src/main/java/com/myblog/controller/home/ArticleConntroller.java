package com.myblog.controller.home;

import com.alibaba.fastjson.JSON;
import com.myblog.entity.Article;
import com.myblog.entity.Comment;
import com.myblog.entity.Tag;
import com.myblog.entity.User;
import com.myblog.enums.ArticleStatus;
import com.myblog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: stone
 * @Date: 2020/01/13 15:57:27
 * @ClassName: ArticleConntroller
 * @Description:
 **/

@Controller
public class ArticleConntroller {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private CommentService commentService;

	@Autowired(required = false)
	private UserService userService;

	@Autowired
	private TagService tagService;

	@Autowired
	private CategoryService categoryService;

	/**
	 * @Author: stone
	 * @Param: articleId 文章ID
	 * @return:
	 * @Description:
	 **/
	@RequestMapping(value = "/article/{articleId}")
	public String getArticleDetailPage(@PathVariable("articleId") Integer articleId, Model model) {
		//文章信息，分类，标签，作者，评论
		Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), articleId);
		if (article == null) {
			return "Home/Error/404";
		}
		//用户信息
		User user = userService.getUserById(article.getArticleUserId());
		article.setUser(user);

		//文章信息
		model.addAttribute("article", article);

		//评论列表
		List<Comment> commentList = commentService.listCommentByArticleId(articleId);
		model.addAttribute("commentList", commentList);

		//相关文章
		List<Integer> categoryIds = articleService.listCategoryIdByArticleId(articleId);
		List<Article> similarArticleList = articleService.listArticleByCategoryIds(categoryIds, 5);
		model.addAttribute("similarArticleList", similarArticleList);

		//猜你喜欢
		List<Article> mostViewArticleList = articleService.listArticleByViewCount(5);
		model.addAttribute("mostViewArticleList", mostViewArticleList);

		//获取下一篇文章
		Article afterArticle = articleService.getAfterArticle(articleId);
		model.addAttribute("afterArticle", afterArticle);

		//获取上一篇文章
		Article preArticle = articleService.getPreArticle(articleId);
		model.addAttribute("preArticle", preArticle);

		//侧边栏
		//标签列表显示
		List<Tag> allTagList = tagService.listTag();
		model.addAttribute("allTagList", allTagList);
		//获得随机文章
		List<Article> randomArticleList = articleService.listRandomArticle(8);
		model.addAttribute("randomArticleList", randomArticleList);
		//获得热评文章
		List<Article> mostCommentArticleList = articleService.listArticleByCommentCount(8);
		model.addAttribute("mostCommentArticleList", mostCommentArticleList);

		return "Home/Page/articleDetail";
	}

	/**
	 * @Author: stone
	 * @Param: id 文章ID
	 * @return: 点赞数量
	 * @Description:
	 **/
	@RequestMapping(value = "/article/like/{id}", method = {RequestMethod.POST})
	@ResponseBody
	public String increaseLikeCount(@PathVariable("id") Integer id) {
		Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), id);
		Integer articleCount = article.getArticleLikeCount() + 1;
		article.setArticleLikeCount(articleCount);
		articleService.updateArticle(article);
		return JSON.toJSONString(articleCount);
	}
	
	/**
	 * @Author: stone
	 * @Param: id 文章ID
	 * @return: 访问数量
	 * @Description: 
	 **/
	@RequestMapping(value = "/article/view/{id}",method = {RequestMethod.POST})
	@ResponseBody
	public String increaseViewCount(@PathVariable("id") Integer id){
		Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), id);
		Integer articleCount = article.getArticleViewCount() + 1;
		article.setArticleViewCount(articleCount);
		articleService.updateArticle(article);
		return JSON.toJSONString(articleCount);

	}
}
