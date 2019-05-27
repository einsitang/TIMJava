package com.sevlow.sdk.tim.api;


import com.sevlow.sdk.tim.common.error.TIMException;
import com.sevlow.sdk.tim.config.TIMConfig;

import java.util.Map;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.api
 * @date 2019-05-27 11:20
 * @Description:
 */
public interface TIMService {

	TIMConfig getConfig();

	/**
	 * 获取UserSig信息
	 * @param identifier
	 * @return
	 * @throws TIMException
	 */
	String getUserSig(String identifier) throws TIMException;

	String get(String api, Map<String,String> queryParams) throws TIMException;

	String post(String api,Object body) throws TIMException;

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
