package com.myblog.service.impl;

import com.myblog.entity.Tag;
import com.myblog.mapper.ArticleTagRefMapper;
import com.myblog.mapper.TagMapper;
import com.myblog.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: stone
 * @Date: 2020/01/14 21:17:24
 * @ClassName: TagServiceImpl
 * @Description:
 **/

@Service
@Slf4j
public class TagServiceImpl implements TagService {

	@Autowired(required = false)
	private TagMapper tagMapper;

	@Autowired(required = false)
	private ArticleTagRefMapper articleTagRefMapper;

	@Override
	public Integer countTag() {
		return tagMapper.countTag();
	}

	@Override
	public List<Tag> listTag() {
		return null;
	}

	@Override
	public List<Tag> listTagWithCount() {
		return null;
	}

	@Override
	public Tag getTagById(Integer id) {
		return null;
	}

	@Override
	public Tag insertTag(Tag tag) {
		return null;
	}

	@Override
	public void updateTag(Tag tag) {

	}

	@Override
	public void deleteTag(Integer id) {

	}

	@Override
	public Tag getTagByName(String name) {
		return null;
	}

	@Override
	public List<Tag> listTagByArticleId(Integer articleId) {
		return null;
	}
}
