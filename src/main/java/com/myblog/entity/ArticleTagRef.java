package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: stone
 * @Date: 2020/01/10 17:45:13
 * @ClassName: ArticleTagRef
 * @Description:
 **/

@Data
public class ArticleTagRef implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer articleId;

	private Integer tagId;

	public ArticleTagRef() {
	}

	public ArticleTagRef(Integer articleId, Integer tagId) {
		this.articleId = articleId;
		this.tagId = tagId;
	}
}
