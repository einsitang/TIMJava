package com.sevlow.sdk.tim.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-28 00:13
 * @Description: TODO
 */
@Data
public class BatchUpdateResult implements Serializable {

	private static final long serialVersionUID = -2729886288572231679L;

	public BatchUpdateResult() {
	}

	@SerializedName("ResultItem")
	private List<ResultItem> resultItems = new ArrayList<>();

	@SerializedName("Fail_Account")
	private List<String> failAccounts = new ArrayList<>();

	@SerializedName("Invalid_Account")
	private List<String> invalidAccounts = new ArrayList<>();

}
