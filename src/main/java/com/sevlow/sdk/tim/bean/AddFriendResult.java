package com.sevlow.sdk.tim.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-27 18:04
 * @Description: TODO
 */
@Data
public class AddFriendResult implements Serializable {

	private static final long serialVersionUID = 8152624238915124107L;

	@SerializedName("ResultItem")
	private ResultItem resultItem;

	@SerializedName("Fail_Account")
	private List<String> failAccounts;

	@SerializedName("Invalid_Account")
	private List<String> invalidAccounts;

}
