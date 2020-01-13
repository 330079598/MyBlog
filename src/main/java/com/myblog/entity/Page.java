package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: stone
 * @Date: 2020/01/10 17:54:31
 * @ClassName: Page
 * @Description:
 **/

@Data
public class Page implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer pageId;

	private String pageKey;

	private String pageTitle;

	private String pageContent;

	private Date pageCreateTime;

	private Date pageUpdateTime;

	private Integer pageViewCount;

	private Integer pageCommentCount;

	private Integer pageStatus;
}
