package com.sevlow.sdk.tim.api;

import com.sevlow.sdk.tim.bean.profile.GenderEnum;
import com.sevlow.sdk.tim.common.error.TIMException;

import java.util.Map;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.api
 * @date 2019-05-27 10:37
 * @Description:
 * 资料管理
 * API Doc : https://cloud.tencent.com/document/product/269/1638
 */
public interface TIMProfileService {

    /**
     *  设置性别
     */
    void setInfoGender(String identifier, GenderEnum genderEnum) throws TIMException;

    /**
     *  设置性别，年龄和学院
     */
    void setInfoGender(String identifier, GenderEnum genderEnum,Integer age,String collage) throws TIMException;


    /**
     *  设置自定义字段和标配字段 map的key为标配或者自定义的key，
     *      标配字段key 如 Tag_Profile_IM_Gender不能简写
     *      自定义字段key 如 Tag_Profile_Custom_Test不能简写,需要提前在im后台设置好
     */
    void setInfoGender(String identifier, Map<String,String> map) throws TIMException;
}
