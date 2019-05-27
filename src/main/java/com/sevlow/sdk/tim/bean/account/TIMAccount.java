package com.sevlow.sdk.tim.bean.account;

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

	/**
	 * 用户名，长度不超过32字节
	 */
	@NotNull
	@SerializedName("Identifier")
	private String identifier;

	/**
	 * 用户昵称
	 */
	@SerializedName("Nick")
	private String nick;

	/**
	 * 用户头像 URL
	 */
	@SerializedName("FaceUrl")
	private String faceUrl;

	/**
	 * 帐号类型，开发者默认无需填写，值0表示普通帐号，1表示机器人帐号
	 */
	@SerializedName("Type")
	private Integer type = 0;

	public TIMAccount(String identifier) {
		this.identifier = identifier;
	}
}
