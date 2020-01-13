package com.myblog.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: stone
 * @Date: 2020/01/10 18:03:25
 * @ClassName: ArticleParam
 * @Description:
 **/

@Data
public class ArticleParam {

	private Integer articleId;

	private String articleTitle;

	private String articleContent;

	private Integer articleParentCategoryId;

	private Integer articleChildCategoryId;

	private Integer articleOrder;

	private Integer articleStatus;

	private List<Integer> articleTagIds;
}
