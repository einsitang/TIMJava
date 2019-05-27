package com.sevlow.sdk.tim.bean;

import com.google.gson.annotations.SerializedName;
import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-27 14:11
 * @Description: TODO
 */
@Data
public class TIMAccount implements Serializable {

	private static final long serialVersionUID = -7237058769283644580L;

	@NotNull
	@SerializedName("Identifier")
	private String identifier;

	@SerializedName("Nick")
	private String nick;

	@SerializedName("FaceUrl")
	private String faceUrl;

	@SerializedName("Type")
	private Integer type = 0;

	public TIMAccount(String identifier) {
		this.identifier = identifier;
	}
}
