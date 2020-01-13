package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: stone
 * @Date: 2020/01/10 17:50:06
 * @ClassName: Menu
 * @Description:
 **/

@Data
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer menuId;

	private String menuName;

	private String menuUrl;

	private Integer menuLevel;

	private String menuIcon;

	private Integer menuOrder;

}
