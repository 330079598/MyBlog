package com.myblog.service.impl;

import com.myblog.entity.Menu;
import com.myblog.mapper.MenuMapper;
import com.myblog.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: stone
 * @Date: 2020/01/14 20:59:44
 * @ClassName: MenuServiceImpl
 * @Description:
 **/

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired(required = false)
	private MenuMapper menuMapper;

	@Override
	public List<Menu> listMenu() {
		List<Menu> menuList = menuMapper.listMenu();
		return menuList;
	}

	@Override
	public Menu insertMenu(Menu menu) {
		return null;
	}

	@Override
	public void deleteMenu(Integer id) {

	}

	@Override
	public void updateMenu(Menu menu) {

	}

	@Override
	public Menu getMenuById(Integer id) {
		return null;
	}
}
