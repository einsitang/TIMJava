package com.sevlow.sdk.tim.api;


import com.sevlow.sdk.tim.common.error.TIMException;
import com.sevlow.sdk.tim.config.TIMConfig;
import lombok.NonNull;

import java.util.Map;

/**
 * @author Element
 *
 * TIMService是所有Service模块的入口
 */
public interface TIMService {

    TIMConfig getConfig();

    /**
     * 获取UserSig信息 (默认过期时间为30天)
     *
     * @param identifier
     * @return
     * @throws TIMException
     */
    String getUserSig(@NonNull String identifier) throws TIMException;

    /**
     * 获取UserSig信息
     *
     * @param identifier
     * @param expireOfDay 过期天数
     * @return
     * @throws TIMException
     */
    String getUserSig(@NonNull String identifier, Integer expireOfDay) throws TIMException;

    /**
     * 通用GET方法
     *
     * @param api         TIM API 地址
     * @param queryParams API 地址所需参数(不包含公共参数)
     * @return
     * @throws TIMException
     */
    String get(String api, Map<String, String> queryParams) throws TIMException;

    /**
     * 通用POST方法
     *
     * @param api  TIM API 地址
     * @param body API 请求体
     * @return
     * @throws TIMException
     */
    String post(String api, Object body) throws TIMException;

    TIMAccountService getAccountService();

    TIMChatService getChatService();

    TIMDirtyWordService getDirtyWordService();

    TIMGroupService getGroupService();

    TIMNoSpeakService getNoSpeakService();

    TIMOnlineStatusService getOnlineStatusService();

    TIMOperationalService getOperationalService();

    TIMProfileService getProfileService();

    TIMRelationService getRelationService();


}
