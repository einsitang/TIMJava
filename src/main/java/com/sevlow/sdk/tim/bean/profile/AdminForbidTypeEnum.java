package com.sevlow.sdk.tim.bean.profile;

import com.google.gson.annotations.SerializedName;

/**
 * @author element
 */

public enum AdminForbidTypeEnum {

    /**
     * 默认值，允许加好友
     */
    @SerializedName("AdminForbid_Type_None")
    NONE("AdminForbid_Type_None"),

    /**
     * 禁止该用户发起加好友请求
     */
    @SerializedName("AdminForbid_Type_SendOut")
    SEND_OUT("AdminForbid_Type_SendOut");

    private String type;
    private AdminForbidTypeEnum(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
