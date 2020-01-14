package com.myblog.service.impl;

import com.myblog.entity.Notice;
import com.myblog.mapper.NoticeMapper;
import com.myblog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: stone
 * @Date: 2020/01/14 20:41:27
 * @ClassName: NoticeServiceImpl
 * @Description:
 **/

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired(required = false)
	private NoticeMapper noticeMapper;

	@Override
	public List<Notice> listNotice(Integer status) {
		return noticeMapper.listNotice(status);
	}

	@Override
	public void insertNotice(Notice notice) {

	}

	@Override
	public void deleteNotice(Integer id) {

	}

	@Override
	public void updateNotice(Notice notice) {

	}

	@Override
	public Notice getNoticeById(Integer id) {
		return null;
	}
}
