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

	private Integer noticeId;

	private String noticeTitle;

	private String noticeContent;

	private Date noticeCreateTime;

	private Date noticeUpdateTime;

	private Integer noticeStatus;

	private Integer noticeOrder;
}
