package com.sevlow.sdk.tim.api;

import com.sevlow.sdk.tim.bean.profile.GenderEnum;
import com.sevlow.sdk.tim.common.error.TIMException;

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
}
