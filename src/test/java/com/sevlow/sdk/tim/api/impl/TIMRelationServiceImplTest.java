package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMRelationService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.api.test.TestModule;
import com.sevlow.sdk.tim.bean.*;
import com.sevlow.sdk.tim.common.error.TIMException;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.api.impl
 * @date 2019-05-27 23:39
 * @Description: TODO
 */
@Slf4j
@Guice(modules = {TestModule.class})
public class TIMRelationServiceImplTest {

	@Inject
	private TIMService timService;

	private TIMRelationService relationService;

	@BeforeTest
	public void before() {
		this.relationService = timService.getRelationService();
	}

	@Test
	public void testAddFriends() throws TIMException {

		AddFriendsResult result = relationService.addFriends("test_1", Arrays.asList("test_2", "test_3", "test_4"), "forTest");

		Assert.assertEquals(3, result.getResultItems().size());
	}

	@Test
	public void testImportFried() throws TIMException {
		ImportFriendsResult result = relationService.importFriends("test_1", Arrays.asList("test_2", "test_3", "test_4"), "forTest");
		Assert.assertEquals(result.getResultItems().size(), 3);
	}

	@Test
	public void testUpdateFriends() throws TIMException {

		List<SnsItem> snsItemList = new ArrayList<>();
		SnsItem snsItem = new SnsItem();

		snsItem.setTag("tag1");
		snsItem.setValue("value1");

		snsItemList.add(snsItem);

		snsItem = new SnsItem();

		snsItem.setTag("tag2");
		snsItem.setValue(2);

		snsItemList.add(snsItem);

		UpdateFriendsResult result = relationService.updateFriends("test_1", Arrays.asList("test_2","test_3","test_4"), null);

		Assert.assertEquals(result.getResultItems().size(), 3);

	}

	@Test
	public void testDeleteFriends() throws TIMException {

		DeleteFriendsResult result = relationService.deleteFriend("test_1",  Arrays.asList("test_2","test_3"));

		Assert.assertEquals(result.getResultItems().size(),2);

	}

}
