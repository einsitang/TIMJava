package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMRelationService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.bean.*;
import com.sevlow.sdk.tim.bean.account.TIMFriend;
import com.sevlow.sdk.tim.bean.relation.ListFriendsDirectivityResult;
import com.sevlow.sdk.tim.bean.relation.ListFriendsResult;
import com.sevlow.sdk.tim.common.error.TIMError;
import com.sevlow.sdk.tim.common.error.TIMException;
import com.sevlow.sdk.tim.utils.JsonUtils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 关系管理实现类
 *
 * @author element
 */
@Slf4j
public class TIMRelationServiceImpl implements TIMRelationService {

    private final String ADD_SOURCE_TYPE_PREFIX = "AddSource_Type_";

    private static final String CUSTOM_PROFILE_PREFIX = "Tag_Profile_Custom_";

    private static final String CUSTOM_SNS_PROFILE_PREFIX = "Tag_SNS_Custom_";

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

        if (friends.isEmpty()) {
            throw new TIMException(new TIMError(30001, "好友列表不能为空"));
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

        if (friends.isEmpty()) {
            throw new TIMException(new TIMError(30001, "好友列表不能为空"));
        }

        String api = "v4/sns/friend_import";

        Map<String, Object> body = new HashMap<>();

        body.put("From_Account", identifier);
        body.put("AddFriendItem", friends);

        return JsonUtils.fromJson(this.timService.post(api, body), ImportFriendsResult.class);
    }

    @Override
    public UpdateFriendsResult updateFriends(@NonNull String identifier, @NonNull List<String> friends, List<SnsItem> snsItems) throws TIMException {

        if (friends.isEmpty()) {
            throw new TIMException(new TIMError(30001, "好友列表不能为空"));
        }

        String api = "v4/sns/friend_update";

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

        if (friends.isEmpty()) {
            throw new TIMException(new TIMError(30001, "好友列表不能为空"));
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

        String api = "v4/sns/friend_delete_all";

        Map<String, Object> body = new HashMap<>();
        body.put("From_Account", identifier);

        this.timService.post(api, body);

    }

    @Override
    public CheckFriendsResult checkFriends(@NonNull String identifier, @NonNull List<String> friends, CheckType checkType) throws TIMException {

        if (friends.isEmpty()) {
            throw new TIMException(new TIMError(30001, "好友列表不能为空"));
        }

        String api = "v4/sns/friend_check";

        Map<String, Object> body = new HashMap<>();
        body.put("From_Account", identifier);
        body.put("To_Account", friends);
        // 如果不是双向检查，则默认为单项检查
        if (!CheckType.CheckResult_Type_Both.equals(checkType)) {
            checkType = CheckType.CheckResult_Type_Singal;
        }
        body.put("CheckType", checkType);
        return JsonUtils.fromJson(this.timService.post(api, body), CheckFriendsResult.class);
    }

    @Override
    public CheckFriendsResult checkFriends(@NonNull String identifier, @NonNull List<String> friends) throws TIMException {
        return checkFriends(identifier, friends, null);
    }

    @Override
    public ListFriendsResult listFriends(@NonNull String account, @NonNull Integer startIndex, Integer standardSequence, Integer customSequence) throws TIMException {
        String api = "v4/sns/friend_get";

        Map<String, Object> body = new HashMap<>();
        body.put("From_Account", account);
        body.put("StartIndex", startIndex);

        if (standardSequence != null) {
            body.put("StandardSequence", standardSequence);
        }

        if (customSequence != null) {
            body.put("CustomSequence", customSequence);
        }

        return JsonUtils.fromJson(this.timService.post(api, body), ListFriendsResult.class);
    }

    @Override
    public ListFriendsResult listFriends(@NonNull String account, @NonNull Integer startIndex) throws TIMException {
        return this.listFriends(account, startIndex, null, null);
    }

    @Override
    public ListFriendsDirectivityResult listFriendsDirectivity(@NonNull String account, @NonNull List<String> friends, List<String> profiles, List<String> customProfiles, List<String> snsProfiles, List<String> customSnsProfiles) throws TIMException {

        if (friends.isEmpty()) {
            throw new TIMException(new TIMError(30001, "查找的好友列表不能为空"));
        }

        if(friends.size() > 100){
            throw new TIMException(new TIMError(90011, "批量目标帐号超过100，请减少 To_Account 中目标帐号数量"));
        }

        List<String> tagList = new ArrayList<>();
        if (profiles != null && !profiles.isEmpty()) {
            tagList.addAll(profiles);
        }

        if (snsProfiles != null && !snsProfiles.isEmpty()) {
            tagList.addAll(snsProfiles);
        }

        if (customProfiles != null && !customProfiles.isEmpty()) {
            for (String custom : customProfiles) {
                if (custom.length() > 8) {
                    throw new TIMException(new TIMError(-1, "自定义资料字段不能超过8个字符"));
                }
                tagList.add(CUSTOM_PROFILE_PREFIX.concat(custom));
            }
        }

        if (customSnsProfiles != null && !customSnsProfiles.isEmpty()) {
            for (String custom : customSnsProfiles) {
                if (custom.length() > 8) {
                    throw new TIMException(new TIMError(-1, "自定义好友资料字段不能超过8个字符"));
                }
                tagList.add(CUSTOM_SNS_PROFILE_PREFIX.concat(custom));
            }
        }

        if (tagList.isEmpty()) {
            throw new TIMException(new TIMError(30001, "拉取的字段不能为空"));
        }

        String api = "v4/sns/friend_get_list";
        Map<String, Object> body = new HashMap<>();
        body.put("From_Account", account);
        body.put("To_Account", friends);
        body.put("TagList", tagList);
        return JsonUtils.fromJson(this.timService.post(api, body), ListFriendsDirectivityResult.class);
    }

    @Override
    public AddBlockAccountsResult addBlockAccounts(@NonNull String identifier, @NonNull List<String> accounts) throws TIMException {

        if (accounts.isEmpty()) {
            throw new TIMException(new TIMError(30001, "屏蔽的用户列表不能为空"));
        }

        String api = "v4/sns/black_list_add";

        Map<String, Object> body = new HashMap<>();

        body.put("From_Account", identifier);
        body.put("To_Account", accounts);
        return JsonUtils.fromJson(this.timService.post(api, body), AddBlockAccountsResult.class);
    }

    @Override
    public RemoveBlockAccountsResult removeblockAccounts(@NonNull String identifier, @NonNull List<String> blockAccounts) throws TIMException {
        if (blockAccounts.isEmpty()) {
            throw new TIMException(new TIMError(30001, "屏蔽的用户列表不能为空"));
        }

        String api = "v4/sns/black_list_delete";

        Map<String, Object> body = new HashMap<>();

        body.put("From_Account", identifier);
        body.put("To_Account", blockAccounts);
        return JsonUtils.fromJson(this.timService.post(api, body), RemoveBlockAccountsResult.class);
    }

    @Override
    public ListBlockAccountsResult listBlockAccounts(@NonNull String identifier, Integer offset, Integer rows, Integer lastSequence) throws TIMException {

        String api = "v4/sns/black_list_get";

        Map<String, Object> body = new HashMap<>();

        body.put("From_Account", identifier);
        body.put("StartIndex", offset);
        body.put("MaxLimited", rows);
        body.put("LastSequence", lastSequence);

        return JsonUtils.fromJson(this.timService.post(api, body), ListBlockAccountsResult.class);
    }

    @Override
    public CheckBlockAccountsResult checkBlockAccounts(@NonNull String identifier, @NonNull List<String> accounts, BlackCheckType checkType) throws TIMException {

        if (accounts.isEmpty()) {
            throw new TIMException(new TIMError(30001, "检查的账号列表不能为空"));
        }

        String api = "v4/sns/black_list_check";

        Map<String, Object> body = new HashMap<>();
        body.put("From_Account", identifier);
        body.put("To_Account", accounts);
        // 只要不是双向验证，默认为单向验证
        if (checkType == null) {
            checkType = BlackCheckType.BlackCheckResult_Type_Both;
        }

        body.put("CheckType", checkType);

        return JsonUtils.fromJson(this.timService.post(api, body), CheckBlockAccountsResult.class);
    }

    @Override
    public AddGroupsResult addGroups(@NonNull String identifier, @NonNull List<String> groupNames, List<String> friends) throws TIMException {
        if (groupNames.isEmpty()) {
            throw new TIMException(new TIMError(30001, "分组列表 不能为空"));
        }
        String api = "v4/sns/group_add";

        Map<String, Object> body = new HashMap<>();
        body.put("From_Account", identifier);
        body.put("GroupName", groupNames);
        body.put("To_Account", friends);
        return JsonUtils.fromJson(this.timService.post(api, body), AddGroupsResult.class);
    }

    @Override
    public DeleteGroupsResult deleteGroups(@NonNull String identifier, @NonNull List<String> groupNames) throws TIMException {
        if (groupNames.isEmpty()) {
            throw new TIMException(new TIMError(30001, "分组列表 不能为空"));
        }
        String api = "v4/sns/group_delete";

        Map<String, Object> body = new HashMap<>();
        body.put("From_Account", identifier);
        body.put("GroupName", groupNames);
        return JsonUtils.fromJson(this.timService.post(api, body), DeleteGroupsResult.class);
    }

    /**
     * 修改好友备注
     */
    @Override
    public void remarkFriend(@NonNull String identifier, @NonNull String friendId, @NonNull String remark) throws TIMException {

        if (remark.length() > 96) {
            throw new TIMException(new TIMError(-1, "备注长度最长不得超过 96 个字节"));
        }

        String api = "v4/sns/friend_update";

        Map<String, Object> body = new HashMap<>(4);

        List updateItem = new ArrayList();

        Map map = new HashMap();

        List<SnsItem<String>> list = new ArrayList<>();

        SnsItem<String> rename = new SnsItem<>();
        rename.setTag("Tag_SNS_IM_Remark");
        rename.setValue(remark);

        list.add(rename);

        map.put("To_Account", friendId);
        map.put("SnsItem", list);

        updateItem.add(map);

        body.put("From_Account", identifier);
        body.put("UpdateItem", updateItem);

        this.timService.post(api, body);
    }


}
