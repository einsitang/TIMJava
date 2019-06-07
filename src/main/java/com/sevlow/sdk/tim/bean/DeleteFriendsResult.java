package com.sevlow.sdk.tim.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-27 19:40
 * @Description:
 */
@Data
public class DeleteFriendsResult {


	@SerializedName("ResultItem")
	private List<ResultItem> resultItems;

}
