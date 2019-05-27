package com.sevlow.sdk.tim.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-28 00:11
 * @Description: TODO
 */
@Data
public class SnsItem<T> implements Serializable {
	private static final long serialVersionUID = -2164515049612843515L;

	@SerializedName("tag")
	private String tag;

	@SerializedName("Value")
	private T value;
}
