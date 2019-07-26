package com.sevlow.sdk.tim.bean.profile;

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
    Female("Gender_Type_Female"),

    /**
     *  男性
     */
    MALE("Gender_Type_Male"),

    /**
     *  未知
     */
    Unknown("Gender_Type_Unknown")
    ;
    private String type ;

    GenderEnum(String type){
        this.type = type ;
    }
}
