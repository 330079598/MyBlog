package com.myblog.enums;

/**
 * @Author: stone
 * @Date: 2020/01/11 19:38:43
 * @EnumName: NoticeStatus
 * @Description:
 **/

public enum NoticeStatus {
	NORMAL(1, "显示"),
	HIDDEN(0, "隐藏");

	private Integer value;

	private String message;

	NoticeStatus(Integer value, String message) {
		this.value = value;
		this.message = message;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
