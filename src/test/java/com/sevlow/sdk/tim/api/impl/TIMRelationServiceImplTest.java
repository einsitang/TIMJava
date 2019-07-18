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

		AddFriendsResult result = relationService.addFriends("71243920540958720", Arrays.asList("69887072709640192", "test_3", "test_4"), "forTest");

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


	@Test
	public void testEmptyFriends() throws TIMException {

		String identifier = "test_1" ;
		relationService.emptyFriends(identifier);

	}


	@Test
	public void testCheckFriends() throws TIMException {
		String identifier = "69887072709640192" ;   //
		List list = Arrays.asList("71243920540958720");  //  71243920540958720
		CheckFriendsResult result = relationService.checkFriends(identifier, list);

		Assert.assertEquals(1,result.getInfoItem().size());

	}


	@Test
	public void testListFriends() throws TIMException {

		ListFriendsResult result = relationService.listFriends("71243920540958720", 0, 10, 0, null);

		Assert.assertNotNull(result);
	}

	@Test
	public void testListFriendsByAccounts() throws TIMException {
		ListFriendsByAccountsResult list = relationService.listFriendsByAccounts("test_1", Arrays.asList("test_2"));

		Assert.assertEquals(list.getInfoItem().size(),1);
	}

	@Test
	public void testAddBlockAccounts() throws TIMException {
		String identifier = "test_1";
		List account = Arrays.asList("test_2");
		AddBlockAccountsResult result = relationService.addBlockAccounts(identifier, account);
		Assert.assertEquals(result.getResultItems().size(),1);

	}


	@Test
	public void testRemoveblockAccounts() throws TIMException  {

		String identifier = "test_1";
		List account = Arrays.asList("test_2");
		RemoveBlockAccountsResult result = relationService.removeblockAccounts(identifier, account);
		Assert.assertEquals(result.getResultItems().size(),1);

	}

	@Test
	public void testListBlockAccounts() throws TIMException {

		String identifier = "test_1" ;
		Integer offset = 0 ;
		Integer rows = 1 ;
		Integer lastSequence = 0 ;
		ListBlockAccountsResult res = relationService.listBlockAccounts(identifier, offset, rows, lastSequence);
		Assert.assertTrue(res.getCurruentSequence() > 0 );
	}

	@Test
	public void testCheckBlockAccounts() throws TIMException {

		String identifier = "test_1";
		List<String> accounts = Arrays.asList("test_2","test_3");
		String checkType = "44";
		CheckBlockAccountsResult result = relationService.checkBlockAccounts(identifier, accounts, checkType);
		Assert.assertTrue(result.getBlackListCheckItems().size() > 0);
	}

	@Test
	public void testAddGroups() throws TIMException {
		String identifier = "test_1" ;
		List<String> groupNames = Arrays.asList("group123");
		AddGroupsResult res = relationService.addGroups(identifier, groupNames, null);
		Assert.assertTrue(res.getResultItems().size() >= 0 );
	}

	@Test
	public void testDeleteGroups() throws TIMException {
		System.out.println(".............");
		String identifier = "test_1" ;
		List<String> groupNames = Arrays.asList("group123");
		DeleteGroupsResult res = relationService.deleteGroups(identifier, groupNames);
		Assert.assertTrue(res.getCurrentSequence() >= 0 );

	}
}
