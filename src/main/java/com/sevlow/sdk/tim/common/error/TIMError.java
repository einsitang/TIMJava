package com.sevlow.sdk.tim.common.error;

import com.google.gson.annotations.SerializedName;
import com.sevlow.sdk.tim.constant.TIMErrorConstant;
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

	@SerializedName("ErrorCode")
	private int errorCode;

	@SerializedName("ErrorInfo")
	private String errorInfo;

	@Override
	public String toString() {
		return "错误: ErrorCode=" + this.errorCode + ", ErrorInfo=" + this.errorInfo + "\n" +
				TIMErrorConstant.getErrorInfo(this.errorCode);
	}

}
