package com.sevlow.sdk.tim.api;

import com.sevlow.sdk.tim.bean.profile.GenderEnum;
import com.sevlow.sdk.tim.bean.profile.TIMProfile;
import com.sevlow.sdk.tim.common.error.TIMException;
import lombok.NonNull;

import java.util.Map;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.api
 * @date 2019-05-27 10:37
 * @Description: 资料管理
 * API Doc : https://cloud.tencent.com/document/product/269/1638
 */
public interface TIMProfileService {

    /**
     * 设置性别
     * 不推荐使用，请使用 setPortrait
     */
    @Deprecated
    void setInfoGender(String identifier, GenderEnum genderEnum) throws TIMException;


    /**
     * 设置资料
     * <p>
     * 支持 标配资料字段 和 自定义资料字段 的设置。
     * <p>
     * API Doc : https://cloud.tencent.com/document/product/269/1500
     *
     * @param identifier
     * @param imProfile     标配资料
     * @param customProfile 自定义资料
     * @throws TIMException
     */
    void setPortrait(@NonNull String identifier, TIMProfile imProfile, Map<String, Object> customProfile) throws TIMException;

    /**
     * 设置资料
     * <p>
     * 支持 标配资料字段 和 自定义资料字段 的设置。
     * <p>
     * API Doc : https://cloud.tencent.com/document/product/269/1500
     *
     * @param identifier
     * @param imProfile     标配资料
     * @throws TIMException
     */
    void setPortrait(@NonNull String identifier, TIMProfile imProfile) throws TIMException;

    /**
     * 设置资料
     * <p>
     * 支持 标配资料字段 和 自定义资料字段 的设置。
     * <p>
     * API Doc : https://cloud.tencent.com/document/product/269/1500
     *
     * @param identifier
     * @param customProfile   自定义资料
     * @throws TIMException
     */
    void setPortrait(@NonNull String identifier, Map<String, Object> customProfile) throws TIMException;
}
