package com.myblog.service.impl;

import com.myblog.entity.User;
import com.myblog.mapper.ArticleMapper;
import com.myblog.mapper.UserMapper;
import com.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: stone
 * @Date: 2020/03/26 23:42:50
 * @ClassName: UserServiceImpl
 * @Description:
 **/

@Service
public class UserServiceImpl implements UserService {


	@Autowired(required = false)
	private UserMapper userMapper;

	@Autowired(required = false)
	private ArticleMapper articleMapper;

	@Override
	public List<User> listUser() {
		return null;
	}

	@Override
	public User getUserById(Integer id) {
		return null;
	}

	@Override
	public void updateUser(User user) {

	}

	@Override
	public void deleteUser(Integer id) {

	}

	@Override
	public User insertUser(User user) {
		return null;
	}

	@Override
	public User getUserByNameOrEmail(String str) {
		return userMapper.getUserByNameOrEmail(str);
	}

	@Override
	public User getUserByName(String name) {
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		return null;
	}
}
