package com.sevlow.sdk.tim.common.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.common.error
 * @date 2019-05-27 11:49
 * @Description: TODO
 */
@Data
@AllArgsConstructor
public class TIMError implements Serializable {

	private static final long serialVersionUID = -906834256793589790L;

	private int code;
	private String msg;

	@Override
	public String toString() {
		return "错误: Code=" + this.code + ", Msg=" + this.msg;
	}

}
