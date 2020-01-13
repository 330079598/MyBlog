package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: stone
 * @Date: 2020/01/10 17:38:16
 * @ClassName: ArticleCategoryRef
 * @Description:
 **/

@Data
public class ArticleCategoryRef implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer articleId;

	private Integer categoryId;

	public ArticleCategoryRef(){

	}

	public ArticleCategoryRef(Integer articleId, Integer categoryId) {
		this.articleId = articleId;
		this.categoryId = categoryId;
	}
}
