package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: stone
 * @Date: 2020/01/10 17:30:53
 * @ClassName: User
 * @Description:
 **/

@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer userId;

	private String userName;

	private String userPass;

	private String userNickname;

	private String userEmail;

	private String userUrl;

	private String userAvatar;

	private String userLastLoginIp;

	private Date userRegisterTime;

	private Date userLastLoginTime;

	private Integer userStatus;

	/**
	 * 文章数量（不是数据库字段）
	 */
	private Integer articleCount;

}
