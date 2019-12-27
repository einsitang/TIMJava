package com.sevlow.sdk.tim.api;

import com.sevlow.sdk.tim.bean.profile.GenderEnum;
import com.sevlow.sdk.tim.bean.profile.TIMProfile;
import com.sevlow.sdk.tim.bean.profile.UserProfileResult;
import com.sevlow.sdk.tim.common.error.TIMException;
import lombok.NonNull;

import java.util.List;
import java.util.Map;

/**
 * @author Element
 *
 * 资料管理
 * API Doc : https://cloud.tencent.com/document/product/269/1638
 */
public interface TIMProfileService {


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
     * @param imProfile  标配资料
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
     * @param customProfile 自定义资料
     * @throws TIMException
     */
    void setPortrait(@NonNull String identifier, Map<String, Object> customProfile) throws TIMException;

    /**
     * 拉取资料
     * <p>
     * 支持拉取好友和非好友的资料字段。
     * 支持拉取 标配资料字段 和 自定义资料字段。
     * 建议每次拉取的用户数不超过100，避免因回包数据量太大导致回包失败。
     * 请确保请求中的所有帐号都已导入即时通信 IM，如果请求中含有未导入即时通信 IM 的帐号，即时通信 IM 后台将会提示错误。
     * </p>
     * API Doc : https://cloud.tencent.com/document/product/269/1639
     *
     * @param accounts       账号集合,不超过100个
     * @param profiles       标配资料字段 @see com.sevlow.sdk.tim.bean.profile.TIMProfile
     * @param customProfiles 自定义资料字段,无需输入Tag_Profile_Custom_，自动补充
     * @throws TIMException
     */
    UserProfileResult getPortrait(@NonNull List<String> accounts, List<String> profiles, List<String> customProfiles) throws TIMException;
}
