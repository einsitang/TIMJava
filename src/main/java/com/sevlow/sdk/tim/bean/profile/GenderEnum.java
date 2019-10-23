package com.sevlow.sdk.tim.bean.profile;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * @author pengshiqing
 * @Date: 2019/7/26
 * @Description:
 */
@Getter
public enum  GenderEnum {
    
    /**
     *  女性
     */
    @SerializedName("Gender_Type_Female")
    Female("Gender_Type_Female"),

    /**
     *  男性
     */
    @SerializedName("Gender_Type_Male")
    MALE("Gender_Type_Male"),

    /**
     *  未知
     */
    @SerializedName("Gender_Type_Unknown")
    Unknown("Gender_Type_Unknown");

    private String type ;

    GenderEnum(String type){
        this.type = type ;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
