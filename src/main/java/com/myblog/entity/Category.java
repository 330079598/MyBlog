package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: stone
 * @Date: 2020/01/10 17:35:00
 * @ClassName: Category
 * @Description:
 **/

@Data
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer categoryId;

	private Integer categoryPid;

	private String categoryName;

	private String categoryDescription;

	private Integer categoryOrder;

	private String categoryIcon;

	/**
	 * 文章数量(费数据库字段)
	 */
	private Integer articleCount;

	public Category(Integer categoryId, Integer categoryPid, String categoryName, String categoryDescription, Integer categoryOrder, String categoryIcon,Integer articleCount) {
		this.categoryId = categoryId;
		this.categoryPid = categoryPid;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.categoryOrder = categoryOrder;
		this.categoryIcon = categoryIcon;
		this.articleCount = articleCount;
	}

	public Category(Integer categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public Category(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * 未分类
	 *
	 * @return 分类
	 */
	public static Category Default() {
		return new Category(100000000, "未分类");
	}
}
