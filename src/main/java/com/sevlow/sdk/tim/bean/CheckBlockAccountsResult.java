package com.sevlow.sdk.tim.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-27 23:05
 * @Description: TODO
 */
@Data
public class CheckBlockAccountsResult extends ResultStruct implements Serializable {

	private static final long serialVersionUID = -7979547907000718945L;

	@SerializedName("BlackListCheckItem")
	private List<BlockListCheckItem> blockListCheckItems = new ArrayList<>();

	@Data
	public static class BlockListCheckItem implements Serializable {

		private static final long serialVersionUID = 7073160753697835818L;

		@SerializedName("To_Account")
		private String account;

		@SerializedName("Relation")
		private BlockCheckRelation relation;

	}

	public static enum BlockCheckRelation{

		// From_Account 的黑名单中有 To_Account，To_Account 的黑名单中也有 From_Account
		BlackCheckResult_Type_BothWay("BlackCheckResult_Type_BothWay"),

		// From_Account 的黑名单中有 To_Account，但 To_Account 的黑名单中没有 From_Account
		BlackCheckResult_Type_AWithB("BlackCheckResult_Type_AWithB"),

		// From_Account 的黑名单中没有 To_Account，但 To_Account 的黑名单中有 From_Account
		BlackCheckResult_Type_BWithA("BlackCheckResult_Type_BWithA"),

		// From_Account 的黑名单中没有 To_Account，To_Account 的黑名单中也没有 From_Account
		BlackCheckResult_Type_NO("BlackCheckResult_Type_NO");

		private String typeInfo;

		private BlockCheckRelation(String typeInfo){
			this.typeInfo = typeInfo;
		}

	}

}
