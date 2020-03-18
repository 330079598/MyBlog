package com.myblog.controller.home;

import com.myblog.service.ArticleService;
import com.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: stone
 * @Date: 2020/03/16 22:25:55
 * @ClassName: CommentController
 * @Description:
 **/

@Controller
@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;

	@Autowired
	private ArticleService articleService;

	/**
	 * @Author: stone
	 * @Param: request
	 * @return:
	 * @Description: 添加评论
	 **/
}
