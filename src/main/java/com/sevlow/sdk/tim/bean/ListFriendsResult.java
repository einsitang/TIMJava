package com.sevlow.sdk.tim.bean;

import com.google.gson.annotations.SerializedName;
import com.sevlow.sdk.tim.bean.relationManage.ListFriendInfoItem;
import lombok.Data;

import java.util.List;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-27 19:40
 * @Description: TODO
 */
@Data
public class ListFriendsResult {
    
    @SerializedName("NeedUpdateAll")
    private String needUpdateAll ;

    @SerializedName("TimeStampNow")
    private Integer timeStampNow ;

    @SerializedName("StartIndex")
    private Integer startIndex ;

    @SerializedName("InfoItem")
    private List<ListFriendInfoItem> infoItems;

    @SerializedName("CurrentStandardSequence")
    private Integer currentStandardSequence ;

    @SerializedName("FriendNum")
    private Integer friendNum ;
}
