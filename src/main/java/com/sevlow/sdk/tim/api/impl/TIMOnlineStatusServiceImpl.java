package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMOnlineStatusService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.bean.OnlineStatusResult;
import com.sevlow.sdk.tim.common.error.TIMError;
import com.sevlow.sdk.tim.common.error.TIMException;
import com.sevlow.sdk.tim.utils.JsonUtils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author element
 */
@Slf4j
public class TIMOnlineStatusServiceImpl implements TIMOnlineStatusService {

	private TIMService timService;

	public TIMOnlineStatusServiceImpl(TIMService timService) {
		this.timService = timService;
	}

	@Override
	public OnlineStatusResult queryState(@NonNull List<String> accounts) throws TIMException {

		if (accounts == null || accounts.size() < 1) {
			throw new RuntimeException("accounts 不能为空集");
		}

		if (accounts.size() > 500) {
			throw new TIMException(new TIMError(90011, "批量发消息目标帐号超过500，请减少 To_Account 中目标帐号数量"));
		}

		String api = "v4/openim/querystate";

		Map<String, List<String>> queryStateBody = new HashMap<>();
		queryStateBody.put("To_Account", accounts);

		String jsonResult = this.timService.post(api, queryStateBody);

		OnlineStatusResult result = JsonUtils.fromJson(jsonResult, OnlineStatusResult.class);

		return result;
	}
}
