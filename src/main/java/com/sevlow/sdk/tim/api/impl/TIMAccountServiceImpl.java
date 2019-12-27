package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMAccountService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.bean.ImportAccountsResult;
import com.sevlow.sdk.tim.bean.account.TIMAccount;
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
public class TIMAccountServiceImpl implements TIMAccountService {

	private TIMService timService;

	public TIMAccountServiceImpl(TIMService timService) {
		this.timService = timService;
	}

	@Override
	public void singleImport(@NonNull TIMAccount account) throws TIMException {

		try {

			this.doSingleImport(account);

		} catch (TIMException e) {

			TIMError error = e.getError();
			int errorCode = error.getErrorCode();
			if (errorCode == 70169) {
				log.warn("出现 TIM 内部错误 , 再重试一遍 (on TIMAccountService.singleImport method only try again)");
				doSingleImport(account);
				return;
			}
			throw e;
		}

	}

	private void doSingleImport(TIMAccount account) throws TIMException {
		String api = "v4/im_open_login_svc/account_import";
		this.timService.post(api, account);
	}

	@Override
	public ImportAccountsResult multiImport(List<String> accounts) throws TIMException {

		if (accounts == null || accounts.size() < 1) {
			return new ImportAccountsResult();
		}

		if(accounts.size() > 100){
			throw new TIMException(new TIMError(70402, "单次用户导入不能超过100个,请分段导入"));
		}

		String api = "v4/im_open_login_svc/multiaccount_import";

		Map<String, List<String>> multiImportBody = new HashMap<>();
		multiImportBody.put("Accounts", accounts);

		String jsonResult = this.timService.post(api, multiImportBody);

		ImportAccountsResult result = JsonUtils.fromJson(jsonResult, ImportAccountsResult.class);

		return result;
	}

	@Override
	public void kick(@NonNull String identifier) throws TIMException {
		String api = "v4/im_open_login_svc/kick";

		Map<String, String> kickBody = new HashMap<>();
		kickBody.put("Identifier", identifier);

		String jsonResult = this.timService.post(api, kickBody);

		log.debug("【TIMJava】kick user( {} ) result : {}", identifier, jsonResult);

	}
}
