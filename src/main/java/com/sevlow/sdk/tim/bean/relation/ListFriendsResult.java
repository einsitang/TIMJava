package com.sevlow.sdk.tim.bean.relation;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 好友列表返回值
 *
 * @author element
 */
@Data
public class ListFriendsResult implements Serializable {

    private static final long serialVersionUID = -4489242246189349542L;

    @SerializedName("UserDataItem")
    private List<UserDataItem> userDataItems = new ArrayList<>();

    /**
     * 标配好友数据的 Sequence，客户端可以保存该 Sequence，下次请求时通过请求的 StandardSequence 字段返回给后台
     */
    @SerializedName("StandardSequence")
    private Integer standardSequence;

    /**
     * 自定义好友数据的 Sequence，客户端可以保存该 Sequence，下次请求时通过请求的 CustomSequence 字段返回给后台
     */
    @SerializedName("CustomSequence")
    private Integer customSequence;

    /**
     * 好友总数
     */
    @SerializedName("FriendNum")
    private Integer friendNum;

    /**
     * 分页的结束标识，非0值表示已完成全量拉取
     */
    @SerializedName("CompleteFlag")
    private Integer completeFlag;

    /**
     * 分页接口下一页的起始位置
     */
    @SerializedName("NextStartIndex")
    private Integer nextStartIndex;

}
