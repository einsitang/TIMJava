package com.sevlow.sdk.tim.bean.relation;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author element
 */
@Data
public class TIMFriendProfile implements Serializable {

    private static final long serialVersionUID = 1417280732333418415L;

    public static final String TAG_SNS_IM_GROUP = "Tag_SNS_IM_Group";
    public static final String TAG_SNS_IM_REMARK = "Tag_SNS_IM_Remark";
    public static final String TAG_SNS_IM_ADD_SOURCE = "Tag_SNS_IM_AddSource";
    public static final String TAG_SNS_IM_ADD_WORDING = "Tag_SNS_IM_AddWording";

    @SerializedName("Tag_SNS_IM_Group")
    private List<String> groups;

    @SerializedName("Tag_SNS_IM_Remark")
    private String remark;

    @SerializedName("Tag_SNS_IM_AddSource")
    private String addSource;

    @SerializedName("Tag_SNS_IM_AddWording")
    private String addWording;
}
