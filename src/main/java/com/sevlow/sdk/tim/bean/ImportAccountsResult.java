package com.sevlow.sdk.tim.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-27 19:44
 * @Description:
 */
@Data
public class ImportAccountsResult implements Serializable {

	@SerializedName("ResultItem")
	private List<ResultItem> resultItems = new ArrayList<>();

	@SerializedName("Fail_Account")
	private List<String> failAccounts = new ArrayList<>();

	@SerializedName("Invalid_Account")
	private List<String> invalidaccount = new ArrayList<>();

}
