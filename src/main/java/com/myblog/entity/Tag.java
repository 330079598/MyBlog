package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: stone
 * @Date: 2020/01/10 17:33:06
 * @ClassName: Tag
 * @Description:
 **/

@Data
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer tagId;

	private String tagName;

	private String tagDescription;

	/**
	 * 文章数量(不是数据库字段)
	 */
	private Integer articleCount;

	public Tag() {
	}

	public Tag(Integer tagId) {
		this.tagId = tagId;
	}

	public Tag(Integer tagId, String tagName, String tagDescription, Integer articleCount) {
		this.tagId = tagId;
		this.tagName = tagName;
		this.tagDescription = tagDescription;
		this.articleCount = articleCount;
	}
}
