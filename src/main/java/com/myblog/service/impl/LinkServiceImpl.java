package com.myblog.service.impl;

import com.myblog.entity.Link;
import com.myblog.mapper.LinkMapper;
import com.myblog.service.LinkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: stone
 * @Date: 2020/01/14 21:19:25
 * @ClassName: LinkServiceImpl
 * @Description:
 **/

@Service
@Slf4j
public class LinkServiceImpl implements LinkService {

	@Autowired(required = false)
	private LinkMapper linkMapper;

	@Override
	public Integer countLink(Integer status) {
		return linkMapper.countLink(status);
	}

	@Override
	public List<Link> listLink(Integer status) {
		return null;
	}

	@Override
	public void insertLink(Link link) {

	}

	@Override
	public void deleteLink(Integer id) {

	}

	@Override
	public void updateLink(Link link) {

	}

	@Override
	public Link getLinkById(Integer id) {
		return null;
	}
}
