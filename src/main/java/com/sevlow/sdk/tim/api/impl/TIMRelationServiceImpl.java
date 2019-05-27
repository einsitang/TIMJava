package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMRelationService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.bean.*;
import com.sevlow.sdk.tim.common.error.TIMException;
import com.sevlow.sdk.tim.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.api.impl
 * @date 2019-05-27 23:27
 * @Description: TODO
 */
@Slf4j
public class TIMRelationServiceImpl implements TIMRelationService {

	private TIMService timService;

	public TIMRelationServiceImpl(TIMService timService) {
		this.timService = timService;
	}

	@Override
	public AddFriendsResult addFriends(String identifier, List<String> friends, String friendSource, AddType addType) throws TIMException {

		if (friends == null || friends.size() < 1) {
			throw new RuntimeException("friends can't be empty");
		}

		String api = "v4/sns/friend_add";

		Map<String, Object> body = new HashMap<>();
		body.put("From_Account", identifier);

		List<Map<String, String>> friendItems = new ArrayList<>();
		Map<String, String> friendItem = null;
		for (String friend : friends) {
			friendItem = new HashMap<>();
			friendItem.put("To_Account", friend);
			friendItem.put("AddSource", "AddSource_Type_" + friendSource);

			friendItems.add(friendItem);
		}

		body.put("AddFriendItem", friendItems);


		if (addType == null) {
			body.put("AddType", AddType.Add_Type_Both);
		}

		return JsonUtils.fromJson(this.timService.post(api, body), AddFriendsResult.class);
	}

	@Override
	public AddFriendsResult addFriends(String identifier, List<String> friends, String friendSource) throws TIMException {
		return this.addFriends(identifier, friends, friendSource, null);
	}

	@Override
	public ImportFriendsResult importFriends(String identifier, List<String> friends, String friendSource) throws TIMException {
		return null;
	}

	@Override
	public DeleteFriendsResult deleteFriend(String identifier, List<String> friends, DeleteType deleteType) throws TIMException {
		return null;
	}

	@Override
	public DeleteFriendsResult deleteFriend(String identifier, List<String> friends) throws TIMException {
		return null;
	}

	@Override
	public void emptyFriends(String identifier) throws TIMException {

	}

	@Override
	public CheckFriendsResult checkFriends(String identifier, List<String> friends, CheckType checkType) throws TIMException {
		return null;
	}

	@Override
	public CheckFriendsResult checkFriends(String identifier, List<String> friends) throws TIMException {
		return null;
	}

	@Override
	public ListFriendsResult listFriends(String identifier, int offset, int rows, Date timestamp, int lastStandardSequence) throws TIMException {
		return null;
	}

	@Override
	public ListFriendsByAccountsResult listFriendsByAccounts(String identifier, List<String> accounts) throws TIMException {
		return null;
	}

	@Override
	public AddBlockAccountsResult blockAccounts(String identifier, List<String> accounts) throws TIMException {
		return null;
	}

	@Override
	public RemoveBlockAccountsResult unblockAccounts(String identifier, List<String> blockAccounts) throws TIMException {
		return null;
	}

	@Override
	public ListBlockAccountsResult listBlockAccounts(String identifier, int offset, int rows, int lastSequence) throws TIMException {
		return null;
	}

	@Override
	public CheckBlockAccountsResult checkBlockAccounts(String identifier, List<String> accounts, CheckType checkType) throws TIMException {
		return null;
	}

	@Override
	public AddGroupsResult addGroups(String identifier, List<String> groupNames, List<String> friends) throws TIMException {
		return null;
	}

	@Override
	public DeleteGroupsResult deleteGroups(String Identifier, List<String> groupNames) throws TIMException {
		return null;
	}
}
