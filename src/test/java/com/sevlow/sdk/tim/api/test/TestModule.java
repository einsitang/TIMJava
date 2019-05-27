package com.sevlow.sdk.tim.api.test;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.api.impl.TIMServiceImpl;
import com.sevlow.sdk.tim.config.TIMConfig;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.api.test
 * @date 2019-05-27 13:27
 * @Description: TODO
 */
public class TestModule implements Module {

	@Override
	public void configure(Binder binder) {

//		Long appId = 1400206328L;
		Long appId = 1400207264L;
		Long accountType = 36862L;

		String priKeyPath = "classpath:private_key.example.txt";
		String adminIdentifier = "admin";

		TIMConfig config = new TIMConfig(appId, priKeyPath, adminIdentifier);
		TIMService timService = new TIMServiceImpl(config);

		binder.bind(TIMConfig.class).toInstance(config);
		binder.bind(TIMService.class).toInstance(timService);

	}
}
