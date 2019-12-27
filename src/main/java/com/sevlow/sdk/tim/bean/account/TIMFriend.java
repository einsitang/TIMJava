package com.sevlow.sdk.tim.bean.account;

import com.google.gson.annotations.SerializedName;
import com.sevlow.sdk.tim.bean.SnsItem;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean.account
 * @date 2019-05-28 11:42
 * @Description:
 */
@Data
public class TIMFriend implements Serializable {

	private static final long serialVersionUID = 7273818295789187835L;

	@NonNull
	@SerializedName("To_Account")
	private String account;

	@SerializedName("Remark")
	private String remark;

	@SerializedName("RemarkTime")
	private Long remarkTime;

	@SerializedName("GroupName")
	private List<String> groupNames ;

	@NonNull
	@SerializedName("AddSource")
	private String addSource;

	@SerializedName("AddWording")
	private String addWoring;

	@SerializedName("AddTime")
	private Long addTime;

	@SerializedName("CustomItem")
	private List<SnsItem> customItems;

}
