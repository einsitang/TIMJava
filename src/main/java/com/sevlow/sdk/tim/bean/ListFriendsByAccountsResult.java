package com.sevlow.sdk.tim.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-27 23:13
 * @Description: TODO
 */
@Data
public class ListFriendsByAccountsResult implements Serializable {
	private static final long serialVersionUID = 7934007519250442782L;

	@SerializedName("InfoItem")
	private List<String> infoItem;

	@Data
	public static class InfoItem implements Serializable{

		private static final long serialVersionUID = -7907211711900625029L;

		@SerializedName("To_Account")
		private String account;

		@SerializedName("SnsProfileItem")
		private List<SnsProfileItem> snsProfileItems;

		@SerializedName("ResultCode")
		private int resultCode;

		@SerializedName("ResultInfo")
		private String resultInfo ;
	}

	@Data
	public static class SnsProfileItem implements Serializable{

		private static final long serialVersionUID = 3421764241344677625L;

		@SerializedName("Tag")
		private String tag;

		@SerializedName("Value")
		private String value;
	}

}
