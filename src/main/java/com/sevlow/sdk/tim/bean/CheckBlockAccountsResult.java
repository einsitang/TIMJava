package com.sevlow.sdk.tim.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-27 23:05
 * @Description:
 */
@Data
public class CheckBlockAccountsResult extends ResultStruct implements Serializable {

	private static final long serialVersionUID = -7979547907000718945L;

	@SerializedName("BlackListCheckItem")
	private List<BlockListCheckItem> blackListCheckItems ;

	@SerializedName("Fail_Account")
	private List<String> failAccounts ;

	@Data
	private class BlockListCheckItem implements Serializable {

		private static final long serialVersionUID = 3866516028140354372L;

		 @SerializedName("To_Account")
		 private String toAccount ;

		 @SerializedName("Relation")
		 private String relation ;

		 @SerializedName("ResultCode")
		 private Integer resultCode ;

		 @SerializedName("ResultInfo")
		 private String resultInfo ;
	}

}
