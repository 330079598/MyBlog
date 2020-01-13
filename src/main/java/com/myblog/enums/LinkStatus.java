package com.myblog.enums;

/**
 * @Author: stone
 * @Date: 2020/01/11 18:01:07
 * @EnumName: LinkStatus
 * @Description:
 **/

public enum LinkStatus {
	NORMAL(1, "显示"),
	HIDDEN(0, "隐藏");

	private Integer value;

	private String message;

	LinkStatus(Integer value, String message) {
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
