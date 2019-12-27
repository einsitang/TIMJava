package com.sevlow.sdk.tim.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-27 23:05
 * @Description:
 */

@Data
public class AddGroupsResult extends BatchUpdateResult implements Serializable {
	private static final long serialVersionUID = -5437234846342240878L;

	@SerializedName("CurrentSequence")
	private int currentSequence;

}
