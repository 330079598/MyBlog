package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: stone
 * @Date: 2020/01/10 17:51:29
 * @ClassName: Notice
 * @Description:
 **/

@Data
public class Notice implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer optionId;

	private String optionSiteTitle;

	private String optionSiteDescrption;

	private String optionMetaDescrption;

	private String optionMetaKeyword;

	private String optionAboutsiteAvatar;

	private String optionAboutsiteTitle;

	private String optionAboutsiteContent;

	private String optionAboutsiteWechat;

	private String optionAboutsiteQq;

	private String optionAboutsiteGithub;

	private String optionAboutsiteWeibo;

	private String optionTongji;

	private Integer optionStatus;
}
