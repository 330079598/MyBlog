package com.myblog.dto;

import lombok.Data;

/**
 * @Author: stone
 * @Date: 2020/01/10 20:19:36
 * @ClassName: ResultVO
 * @Description:
 **/

@Data
public class ResultVO<T> {
	/**
	 * 错误码
	 */
	private Integer code;

	/**
	 * 提示信息
	 */
	private String msg;

	/**
	 * 返回的具体内容
	 */
	private T data;


	public ResultVO(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public ResultVO() {
	}
}