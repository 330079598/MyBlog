package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: stone
 * @Date: 2020/01/10 17:48:49
 * @ClassName: Link
 * @Description:
 **/

@Data
public class Link implements Serializable {
	private static final long seriaVersionUID = 1L;

	private Integer linkId;

	private String linkUrl;

	private String linkName;

	private String linkImage;

	private String linkDescription;

	private String linkOwnerNickname;

	private String linkOwnerContact;

	private Date linkUpdateTime;

	private Date linkCreateTime;

	private Integer linkOrder;

	private Integer linkStatus;
}
