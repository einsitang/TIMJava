package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.*;
import com.sevlow.sdk.tim.common.TLSSigature;
import com.sevlow.sdk.tim.common.error.TIMError;
import com.sevlow.sdk.tim.common.error.TIMException;
import com.sevlow.sdk.tim.config.TencentIMConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.api.impl
 * @date 2019-05-27 11:23
 * @Description: TODO
 */
@Slf4j
public class TIMServiceImpl implements TIMService {

	private TencentIMConfig config;

	public TIMServiceImpl(TencentIMConfig config) {
		this.config = config;
	}

	@Override
	public String getUserSig(String identifier) throws TIMException {

		TLSSigature.GenTLSSignatureResult signatureResult;

		try {
			InputStream fis = TencentIMConfig.class.getResourceAsStream("classpath:" + config.getPrivateKeyPath());
			String priKey = IOUtils.toString(fis, "utf-8");

			signatureResult = TLSSigature.GenTLSSignatureEx(config.getAppId(), identifier, priKey, 60 * 60 * 24 * 30);
			if (signatureResult == null || signatureResult.urlSig == null) {
				throw new TIMException(new TIMError(-1, "UserSig生成失败"));
			}

		} catch (TIMException e) {
			throw e;
		} catch (Exception e) {
			throw new TIMException(new TIMError(-1, e.getMessage()));
		}

		return signatureResult.urlSig;
	}

	@Override
	public TIMAccountService getAccountService() {
		return null;
	}

	@Override
	public TIMChatService getChatService() {
		return null;
	}

	@Override
	public TIMDirtyWordService getDirtyWordService() {
		return null;
	}

	@Override
	public TIMGroupService getGroupService() {
		return null;
	}

	@Override
	public TIMNoSpeakService getNoSpeakService() {
		return null;
	}

	@Override
	public TIMOnlineStatusService getOnlineStatusService() {
		return null;
	}

	@Override
	public TIMOperationalService getOperationalService() {
		return null;
	}

	@Override
	public TIMProfileService getProfileService() {
		return null;
	}

	@Override
	public TIMRelService getRelService() {
		return null;
	}
}
