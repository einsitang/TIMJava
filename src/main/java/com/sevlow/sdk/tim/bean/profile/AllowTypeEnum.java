package com.sevlow.sdk.tim.bean.profile;

import com.google.gson.annotations.SerializedName;

public enum AllowTypeEnum {

    /**
     * 需要经过自己确认才能添加自己为好友
     */
    @SerializedName("AllowType_Type_NeedConfirm")
    NEED_CONFIRM("AllowType_Type_NeedConfirm"),

    /**
     * 允许任何人添加自己为好友
     */
    @SerializedName("AllowType_Type_AllowAny")
    ALLOW_ANY("AllowType_Type_AllowAny"),

    /**
     * 不允许任何人添加自己为好友
     */
    @SerializedName("AllowType_Type_DenyAny")
    DENY_ANY("AllowType_Type_DenyAny");

    private String type;
    private AllowTypeEnum(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
