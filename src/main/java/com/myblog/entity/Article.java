package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: stone
 * @Date: 2020/01/10 17:27:38
 * @ClassName: Article
 * @Description:
 **/

@Data
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer articleId;

	private Integer articleUserId;

	private String articleTitle;

	private Integer articleViewCount;

	private Integer articleCommentCount;

	private Integer articleLikeCount;

	private Date articleCreateTime;

	private Date articleUpdateTime;

	private Integer articleIsComment;

	private Integer articleStatus;

	private Integer articleOrder;

	private String articleContent;

	private String articleSummary;

	private User user;

	private List<Tag> tagList;

	private List<Category> categoryList;
}
