package com.sevlow.sdk.tim.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-27 18:08
 * @Description: TODO
 */
@Data
public class ResultItem extends ResultStruct implements Serializable {

	private static final long serialVersionUID = -1825495492551857861L;

	@SerializedName("To_Account")
	private String account;


}
