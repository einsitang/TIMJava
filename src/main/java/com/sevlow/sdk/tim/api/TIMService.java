package com.sevlow.sdk.tim.api;


import com.sevlow.sdk.tim.common.error.TIMException;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.api
 * @date 2019-05-27 11:20
 * @Description:
 */
public interface TIMService {

	/**
	 * 获取UserSig信息
	 * @param identifier
	 * @return
	 * @throws TIMException
	 */
	String getUserSig(String identifier) throws TIMException;

	TIMAccountService getAccountService();

	TIMChatService getChatService();

	TIMDirtyWordService getDirtyWordService();

	TIMGroupService getGroupService();

	TIMNoSpeakService getNoSpeakService();

	TIMOnlineStatusService getOnlineStatusService();

	TIMOperationalService getOperationalService();

	TIMProfileService getProfileService();

	TIMRelService getRelService();

}
