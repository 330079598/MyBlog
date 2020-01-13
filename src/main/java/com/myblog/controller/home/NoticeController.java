package com.myblog.controller.home;

import com.myblog.entity.Article;
import com.myblog.entity.Notice;
import com.myblog.service.ArticleService;
import com.myblog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: stone
 * @Date: 2020/01/13 16:08:47
 * @ClassName: NoticeController
 * @Description:
 **/

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@Autowired
	private ArticleService articleService;

	/**
	 * @Author: stone
	 * @Param: noticeId
	 * @return: 
	 * @Description: 公告详情页显示
	 **/
	@RequestMapping(value = "/notice/{noticeId}")
	public String NoticeDetailView(@PathVariable("noticeId") Integer noticeId,
	                               Model model) {
		//公告内容和信息显示
		Notice notice = noticeService.getNoticeById(noticeId);
		model.addAttribute("notice",notice);

		//侧边栏显示
		//获得热评文章
		List<Article> mostCommentArticleList = articleService.listArticleByCommentCount(8);
		model.addAttribute("mostCommentArticleList", mostCommentArticleList);
		return "Home/Page?noticeDetail";
	}
}
