package com.sevlow.sdk.tim.api;

import com.sevlow.sdk.tim.bean.OnlineStatusResult;
import com.sevlow.sdk.tim.common.error.TIMException;

import java.util.List;

/**
 * @author Element
 *
 * 在线状态
 * API Doc : https://cloud.tencent.com/document/product/269/2565
 */
public interface TIMOnlineStatusService {

	/**
	 * 获取用户在线状态
	 *
	 * 获取用户当前的登录状态。
	 *
	 * API Doc : https://cloud.tencent.com/document/product/269/2566
	 * @param accounts
	 * @return
	 * @throws TIMException
	 */
	OnlineStatusResult queryState(List<String> accounts) throws TIMException;

}


