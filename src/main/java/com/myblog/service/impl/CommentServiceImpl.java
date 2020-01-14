package com.myblog.service.impl;

import com.github.pagehelper.PageInfo;
import com.myblog.entity.Article;
import com.myblog.entity.Comment;
import com.myblog.enums.ArticleStatus;
import com.myblog.mapper.ArticleMapper;
import com.myblog.mapper.CommentMapper;
import com.myblog.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: stone
 * @Date: 2020/01/14 21:22:39
 * @ClassName: CommentServiceImpl
 * @Description:
 **/

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

	@Autowired(required = false)
	private CommentMapper commentMapper;

	@Autowired(required = false)
	private ArticleMapper articleMapper;

	@Override
	public void insertComment(Comment comment) {

	}

	@Override
	public List<Comment> listCommentByArticleId(Integer articleId) {
		return null;
	}

	@Override
	public Comment getCommentById(Integer id) {
		return null;
	}

	@Override
	public PageInfo<Comment> listCommentByPage(Integer pageIndex, Integer pageSize) {
		return null;
	}

	@Override
	public List<Comment> listComment() {
		return null;
	}

	@Override
	public void deleteComment(Integer id) {

	}

	@Override
	public void updateComment(Comment comment) {

	}

	@Override
	public Integer countComment() {
		return null;
	}

	@Override
	public List<Comment> listRecentComment(Integer limit) {
		List<Comment> commentList = null;
		try {
			commentList = commentMapper.listRecentComment(limit);
			for(int i = 0;i < commentList.size();i ++){
				Article article = articleMapper.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), commentList.get(i).getCommentArticleId());
				commentList.get(i).setArticle(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("获得最新评论失败,limit:{},cause:{}", limit,e);
		}
		return null;
	}

	@Override
	public List<Comment> listChildComment(Integer id) {
		return null;
	}
}
