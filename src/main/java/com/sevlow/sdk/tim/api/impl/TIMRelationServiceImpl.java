package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMRelationService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.bean.*;
import com.sevlow.sdk.tim.bean.account.TIMFriend;
import com.sevlow.sdk.tim.common.error.TIMError;
import com.sevlow.sdk.tim.common.error.TIMException;
import com.sevlow.sdk.tim.utils.JsonUtils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.api.impl
 * @date 2019-05-27 23:27
 * @Description: TODO
 */
@Slf4j
public class TIMRelationServiceImpl implements TIMRelationService {

	private final String ADD_SOURCE_TYPE_PREFIX = "AddSource_Type_";

	private TIMService timService;

	public TIMRelationServiceImpl(TIMService timService) {
		this.timService = timService;
	}

	private String cleanAddSourceTypePrefix(String addSourceType) throws TIMException {
		if (StringUtils.startsWith(addSourceType, ADD_SOURCE_TYPE_PREFIX)) {
			addSourceType = RegExUtils.removeFirst(addSourceType, ADD_SOURCE_TYPE_PREFIX);
		}

		if (addSourceType.length() > 8) {
			throw new TIMException(new TIMError(30001, "addSourceType除去前缀Add_Source_外，不能多于8个字符"));
		}
		return addSourceType;
	}

	@Override
	public AddFriendsResult addFriends(@NonNull String identifier, @NonNull List<String> friends, @NonNull String friendSource, AddType addType) throws TIMException {

		if (friends == null || friends.size() < 1) {
			throw new RuntimeException("friends can't be empty");
		}

		String api = "v4/sns/friend_add";

		friendSource = cleanAddSourceTypePrefix(friendSource);

		Map<String, Object> body = new HashMap<>();
		body.put("From_Account", identifier);

		List<Map<String, String>> friendItems = new ArrayList<>();
		Map<String, String> friendItem = null;
		for (String friend : friends) {
			friendItem = new HashMap<>();
			friendItem.put("To_Account", friend);
			friendItem.put("AddSource", ADD_SOURCE_TYPE_PREFIX + friendSource);

			friendItems.add(friendItem);
		}

		body.put("AddFriendItem", friendItems);


		if (addType == null) {
			body.put("AddType", AddType.Add_Type_Both);
		}

		return JsonUtils.fromJson(this.timService.post(api, body), AddFriendsResult.class);
	}

	@Override
	public AddFriendsResult addFriends(@NonNull String identifier, @NonNull List<String> friends, @NonNull String friendSource) throws TIMException {
		return this.addFriends(identifier, friends, friendSource, null);
	}

	@Override
	public ImportFriendsResult importFriends(@NonNull String identifier, @NonNull List<String> friends, @NonNull String friendSource) throws TIMException {

		if (friends == null || friends.size() < 1) {
			throw new RuntimeException("friends can't be empty");
		}

		friendSource = cleanAddSourceTypePrefix(friendSource);

		List<TIMFriend> list = new ArrayList<>();
		TIMFriend timFriend = null;

		for (String friend : friends) {
			timFriend = new TIMFriend(friend, ADD_SOURCE_TYPE_PREFIX + friendSource);
			list.add(timFriend);
		}

		return this.importFriends(identifier, list);
	}

	@Override
	public ImportFriendsResult importFriends(@NonNull String identifier, @NonNull List<TIMFriend> friends) throws TIMException {

		String api = "v4/sns/friend_import";

		Map<String, Object> body = new HashMap<>();

		body.put("From_Account", identifier);
		body.put("AddFriendItem", friends);

		return JsonUtils.fromJson(this.timService.post(api, body), ImportFriendsResult.class);
	}

	@Override
	public UpdateFriendsResult updateFriends(@NonNull String identifier, @NonNull List<String> friends, List<SnsItem> snsItems) throws TIMException {

		String api = "v4/sns/friend_update";

		if (friends == null || friends.size() < 1) {
			throw new RuntimeException("friends can't be empty");
		}

		Map<String, Object> body = new HashMap<>();
		body.put("From_Account", identifier);

		List<Map<String, Object>> updateItems = new ArrayList<>();
		Map<String, Object> updateItem = null;

		for (String friend : friends) {

			updateItem = new HashMap<>();
			updateItem.put("To_Account", friend);
			updateItem.put("SnsItem", snsItems);

			updateItems.add(updateItem);
		}

		body.put("UpdateItem", updateItems);

		return JsonUtils.fromJson(this.timService.post(api, body), UpdateFriendsResult.class);
	}

	@Override
	public DeleteFriendsResult deleteFriend(@NonNull String identifier, @NonNull List<String> friends, DeleteType deleteType) throws TIMException {

		if (friends == null || friends.size() < 1) {
			throw new RuntimeException("friends can't be empty");
		}

		String api = "v4/sns/friend_delete";

		Map<String, Object> body = new HashMap<>();
		body.put("From_Account", identifier);
		body.put("To_Account", friends);

		if (deleteType == null) {
			deleteType = DeleteType.Delete_Type_Both;
		}

		body.put("DeleteType", deleteType);

		return JsonUtils.fromJson(this.timService.post(api, body), DeleteFriendsResult.class);
	}

	@Override
	public DeleteFriendsResult deleteFriend(@NonNull String identifier, @NonNull List<String> friends) throws TIMException {
		return deleteFriend(identifier, friends, null);
	}

	@Override
	public void emptyFriends(@NonNull String identifier) throws TIMException {

	}

	@Override
	public CheckFriendsResult checkFriends(@NonNull String identifier, @NonNull List<String> friends, CheckType checkType) throws TIMException {
		return null;
	}

	@Override
	public CheckFriendsResult checkFriends(@NonNull String identifier, @NonNull List<String> friends) throws TIMException {
		return null;
	}

	@Override
	public ListFriendsResult listFriends(@NonNull String identifier, int offset, int rows, Date timestamp, int lastStandardSequence) throws TIMException {
		return null;
	}

	@Override
	public ListFriendsByAccountsResult listFriendsByAccounts(@NonNull String identifier, @NonNull List<String> accounts) throws TIMException {
		return null;
	}

	@Override
	public AddBlockAccountsResult addBlockAccounts(@NonNull String identifier, @NonNull List<String> accounts) throws TIMException {
		return null;
	}

	@Override
	public RemoveBlockAccountsResult removeblockAccounts(@NonNull String identifier, @NonNull List<String> blockAccounts) throws TIMException {
		return null;
	}

	@Override
	public ListBlockAccountsResult listBlockAccounts(@NonNull String identifier, int offset, int rows, int lastSequence) throws TIMException {
		return null;
	}

	@Override
	public CheckBlockAccountsResult checkBlockAccounts(@NonNull String identifier, @NonNull List<String> accounts, CheckType checkType) throws TIMException {
		return null;
	}

	@Override
	public AddGroupsResult addGroups(@NonNull String identifier, @NonNull List<String> groupNames, @NonNull List<String> friends) throws TIMException {
		return null;
	}

	@Override
	public DeleteGroupsResult deleteGroups(@NonNull String Identifier, @NonNull List<String> groupNames) throws TIMException {
		return null;
	}


}
