package com.sevlow.sdk.tim.api;

import com.sevlow.sdk.tim.bean.ImportAccountsResult;
import com.sevlow.sdk.tim.bean.account.TIMAccount;
import com.sevlow.sdk.tim.common.error.TIMException;
import lombok.NonNull;

import java.util.List;

/**
 * @author Element
 *
 * 账号管理
 * API Doc : https://cloud.tencent.com/document/product/269/1607
 */
public interface TIMAccountService {

	/**
	 * 账号导入接口
	 *
	 * 该接口的功能是在云通信 IM 创建一个内部 ID，使没有登录云通信 IM 的 App 自有帐号能够使用云通信 IM 服务。
	 *
	 * API Doc : https://cloud.tencent.com/document/product/269/1608
	 * @param account
	 */
	void singleImport(TIMAccount account) throws TIMException;

	/**
	 * 帐号批量导入接口
	 *
	 * 该接口的功能是在云通信 IM 创建一个内部 ID，使没有登录云通信 IM 的 App 自有帐号能够使用云通信 IM 服务。
	 *
	 * API Doc : https://cloud.tencent.com/document/product/269/4919
	 * @param accounts
	 * @return
	 */
	ImportAccountsResult multiImport(List<String> accounts) throws TIMException;

	/**
	 * 帐号登录态失效接口
	 *
	 * 本接口适用于将 App 用户帐号的登录态（如 UserSig）失效。
	 * 使用该接口将用户登录态失效后，用户如果使用重新生成的UserSig可以成功登录云通信 IM，接口支持一次失效一个帐号。
	 *
	 * API Doc : https://cloud.tencent.com/document/product/269/3853
	 * @param identifier
	 */
	void kick(@NonNull String identifier) throws TIMException;

}
