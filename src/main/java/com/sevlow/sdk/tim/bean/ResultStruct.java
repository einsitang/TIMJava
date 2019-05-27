package com.sevlow.sdk.tim.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-28 00:21
 * @Description: TODO
 */
@Data
public class ResultStruct implements Serializable {
	private static final long serialVersionUID = 353393257485002138L;

	@SerializedName("ResultCode")
	private int resultCode;

	@SerializedName("ResultInfo")
	private String resultInfo;

}
