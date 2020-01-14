package com.myblog.service.impl;

import com.myblog.entity.Category;
import com.myblog.mapper.ArticleCategoryRefMapper;
import com.myblog.mapper.CategoryMapper;
import com.myblog.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: stone
 * @Date: 2020/01/14 21:03:07
 * @ClassName: CategoryServiceImpl
 * @Description:
 **/

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

	@Autowired(required = false)
	private CategoryMapper categoryMapper;

	@Autowired(required = false)
	private ArticleCategoryRefMapper articleCategoryRefMapper;

	@Override
	public Integer countCategory() {
		return null;
	}

	@Override
	public List<Category> listCategory() {
		List<Category> categoryList = null;
		try {
			categoryList = categoryMapper.listCategory();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("根据文章获得分类列表失败,cause:{}",e);
		}
		return categoryList;
	}

	@Override
	public List<Category> listCategoryWithCount() {
		return null;
	}

	@Override
	public void deleteCategory(Integer id) {

	}

	@Override
	public Category getCategoryById(Integer id) {
		return null;
	}

	@Override
	public Category insertCategory(Category category) {
		return null;
	}

	@Override
	public void updateCategory(Category category) {

	}

	@Override
	public Category getCategoryByName(String name) {
		return null;
	}
}
