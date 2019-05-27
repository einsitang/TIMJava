package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMOnlineStatusService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.api.test.TestModule;
import com.sevlow.sdk.tim.bean.TIMOnlineStatus;
import com.sevlow.sdk.tim.common.error.TIMException;
import com.sevlow.sdk.tim.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.api.impl
 * @date 2019-05-27 17:50
 * @Description: TODO
 */
@Slf4j
@Guice(modules = {TestModule.class})
public class TIMOnlineStatusServiceImplTest {

	@Inject
	private TIMService timService;

	@Test
	public void testQueryState() throws TIMException {

		TIMOnlineStatusService onlineStatusService = timService.getOnlineStatusService();

		String[] arr = new String[]{
				"test_1","test_2","test_3"
		};

		List<String> accounts = Arrays.asList(arr);

		TIMOnlineStatus onlineStatus = onlineStatusService.queryState(accounts);

		List<TIMOnlineStatus.AccountState> results = onlineStatus.getQueryResult();

		TIMOnlineStatus.State test1State = null ;

		for(TIMOnlineStatus.AccountState result : results){
			if("test_1".equals(result.getAccount())){
				test1State = result.getState();
				break;
			}
		}

		Assert.assertEquals(TIMOnlineStatus.State.Offline, test1State);

		log.debug(JsonUtils.toJson(onlineStatus));

	}

}
