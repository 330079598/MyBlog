package com.myblog.service.impl;

import com.github.pagehelper.PageInfo;
import com.myblog.entity.Article;
import com.myblog.mapper.ArticleCategoryRefMapper;
import com.myblog.mapper.ArticleMapper;
import com.myblog.mapper.ArticleTagRefMapper;
import com.myblog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: stone
 * @Date: 2020/01/11 22:33:34
 * @ClassName: ArticleServiceImpl
 * @Description:
 **/

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

	@Autowired(required = false)
	private ArticleMapper articleMapper;

	@Autowired(required = false)
	private ArticleCategoryRefMapper articleCategoryRefMapper;

	@Autowired(required = false)
	private ArticleTagRefMapper articleTagRefMapper;

	@Override
	public Integer countArticle(Integer status) {
		return null;
	}

	@Override
	public Integer countArticleComment() {
		return null;
	}

	@Override
	public Integer countArticleView() {
		return null;
	}

	@Override
	public Integer countArticleByCategoryId(Integer categoryId) {
		return null;
	}

	@Override
	public Integer countArticleByTagId(Integer tagId) {
		return null;
	}

	@Override
	public List<Article> listArticle(HashMap<String, Object> criteria) {
		return null;
	}

	@Override
	public List<Article> listRecentArticle(Integer limit) {
		return articleMapper.listArticleByLimit(limit);
	}

	@Override
	public void updateArticleDetail(Article article) {

	}

	@Override
	public void updateArticle(Article article) {

	}

	@Override
	public void deleteArticleBatch(List<Integer> ids) {

	}

	@Override
	public void deleteArticle(Integer id) {

	}

	@Override
	public PageInfo<Article> pageArticle(Integer pageIndex, Integer pageSize, HashMap<String, Object> criteria) {
		return null;
	}

	@Override
	public Article getArticleByStatusAndId(Integer status, Integer id) {
		return null;
	}

	@Override
	public List<Article> listArticleByViewCount(Integer limit) {
		return null;
	}

	@Override
	public Article getAfterArticle(Integer id) {
		return null;
	}

	@Override
	public Article getPreArticle(Integer id) {
		return null;
	}

	@Override
	public List<Article> listRandomArticle(Integer limit) {
		return null;
	}

	@Override
	public List<Article> listArticleByCommentCount(Integer limit) {
		return null;
	}

	@Override
	public void insertArticle(Article article) {

	}

	@Override
	public void updateCommentCount(Integer articleId) {

	}

	@Override
	public Article getLastUpdateArticle() {

		return articleMapper.getLastUpdateArticle();
	}

	@Override
	public List<Article> listArticleByCategoryId(Integer cateId, Integer limit) {
		return null;
	}

	@Override
	public List<Article> listArticleByCategoryIds(List<Integer> cateIds, Integer limit) {
		return null;
	}

	@Override
	public List<Integer> listCategoryIdByArticleId(Integer articleId) {
		return null;
	}

	@Override
	public List<Article> listAllNotWithContent() {
		return null;
	}
}
