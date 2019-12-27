package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMGroupService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.bean.chat.MsgBody;
import com.sevlow.sdk.tim.bean.chat.MsgCustomContent;
import com.sevlow.sdk.tim.bean.group.*;
import com.sevlow.sdk.tim.common.error.TIMException;
import com.sevlow.sdk.tim.utils.JsonUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author pengshiqing
 * @Date: 2019/11/19
 * @Description:
 */
public class TIMGroupServiceImpl implements TIMGroupService {

    private TIMService timService;

    public TIMGroupServiceImpl(TIMService timService) {
        this.timService = timService;
    }


    @Override
    public AllGroupResult getAllGroup(GroupInfo.Type type) throws TIMException {

        Map map = new HashMap(2);

        if (type != null) {
            map.put("GroupType", type);
        }
        return this.getGroup(map);
    }


    @Override
    public AllGroupResult pageGroup(int next, int limit, GroupInfo.Type type) throws TIMException {

        Map map = new HashMap(2);
        map.put("Next", next);
        map.put("Limit", limit);
        if (type != null) {
            map.put("GroupType", type);
        }
        return this.getGroup(map);
    }

    AllGroupResult getGroup(Map map) throws TIMException {
        String api = "v4/group_open_http_svc/get_appid_group_list";
        return JsonUtils.fromJson(this.timService.post(api, map), AllGroupResult.class);
    }

    @Override
    public CreateGroupResult createGroup(GroupInfo groupInfo) throws TIMException {

        String api = "v4/group_open_http_svc/create_group";

        return JsonUtils.fromJson(this.timService.post(api, groupInfo), CreateGroupResult.class);
    }

    @Override
    public void updateGroup(GroupInfo groupInfo) throws TIMException {

        String api = "v4/group_open_http_svc/modify_group_base_info";

        this.timService.post(api, groupInfo);
    }

    @Override
    public AddGroupResult addGroupMember(String groupId, List<String> members, SilenceEnum silenceEnum) throws TIMException {

        String api = "v4/group_open_http_svc/add_group_member";

        Map map = new HashMap<>(3);
        map.put("GroupId", groupId);
        if (silenceEnum != null) {
            map.put("Silence", silenceEnum.getType());
        }

        List<MemberAccount> memberList = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(members)) {
            memberList = members.stream().map(MemberAccount::new).collect(Collectors.toList());
        }

        map.put("MemberList", memberList);

        return JsonUtils.fromJson(this.timService.post(api, map), AddGroupResult.class);
    }

    @Override
    public AddGroupResult addGroupMember(String groupId, List<String> members) throws TIMException {
        return this.addGroupMember(groupId, members, null);
    }


    @Override
    public void deleteGroupMember(String groupId, List<String> members, SilenceEnum silenceEnum, String reason) throws TIMException {
        String api = "v4/group_open_http_svc/delete_group_member";

        Map map = new HashMap<>(3);
        map.put("GroupId", groupId);

        if (silenceEnum != null) {
            map.put("Silence", silenceEnum.getType());
        }
        if (StringUtils.isNotBlank(reason)) {
            map.put("Reason", reason);
        }
        map.put("MemberToDel_Account", members);
        this.timService.post(api, map);
    }


    @Override
    public void modifyGroupMemberInfo(GroupMemberInfo groupMemberInfo) throws TIMException {
        String api = "v4/group_open_http_svc/modify_group_member_info";
        this.timService.post(api, groupMemberInfo);
    }

    @Override
    public void destroyGroup(String groupId) throws TIMException {
        String api = "v4/group_open_http_svc/destroy_group";
        Map map = new HashMap(2);
        map.put("GroupId", groupId);
        this.timService.post(api, map);
    }

    @Override
    public void forbidSendMsg(String groupId, List<String> members, int time) throws TIMException {
        String api = "v4/group_open_http_svc/forbid_send_msg";
        Map map = new HashMap(2);
        if (time < 0) {
            time = 0;
        }
        map.put("GroupId", groupId);
        map.put("Members_Account", members);
        map.put("ShutUpTime", time);
        this.timService.post(api, map);
    }


    @Override
    public ShuttedMemberResult getShuttedMember(String groupId) throws TIMException {
        String api = "v4/group_open_http_svc/get_group_shutted_uin";

        Map map = new HashMap<>(3);
        map.put("GroupId", groupId);
        return JsonUtils.fromJson(this.timService.post(api, map), ShuttedMemberResult.class);
    }


    @Override
    public void sendGroupMsg(String groupId, String account, Boolean isSentOnline, String message) throws TIMException {
        String api = "v4/group_open_http_svc/send_group_msg";

        Map map = new HashMap<>(5);
        map.put("GroupId", groupId);
        if (StringUtils.isNotBlank(account)) {
            map.put("From_Account", account);
        }
        if (isSentOnline != null && isSentOnline) {
            map.put("OnlineOnlyFlag", 1);
        }
        map.put("Random", RandomUtils.nextInt(1000000, 10000000));

        map.put("MsgBody", Collections.singletonList(new TIMTextElem(message)));

        this.timService.post(api, map);
    }

    /**
     * 发送自定义消息
     *
     * @param groupId
     * @param account
     * @param isSentOnline true 则消息表示只在线下发，不存离线和漫游（AVChatRoom 和 BChatRoom 不允许使用）。
     * @param message      自定义消息内容
     */
    @Override
    public void sentGroupCustomMsg(String groupId, String account, Boolean isSentOnline, MsgCustomContent message) throws TIMException {
        String api = "v4/group_open_http_svc/send_group_msg";


        Map body = new HashMap<>(5);
        body.put("GroupId", groupId);
        if (StringUtils.isNotBlank(account)) {
            body.put("From_Account", account);
        }
        if (isSentOnline != null && isSentOnline) {
            body.put("OnlineOnlyFlag", 1);
        }
        body.put("Random", RandomUtils.nextInt(1000000, 10000000));

        List<MsgBody> msgBodies = new ArrayList<>();

        MsgBody msgBody = new MsgBody();
        msgBody.setMsgType("TIMCustomElem");
        msgBody.setMsgContent(message);
        msgBodies.add(msgBody);
        body.put("MsgBody", msgBodies);

        this.timService.post(api, body);
    }


    @Override
    public void sendGroupSystemNotification(String groupId, List<String> toMembers, String message) throws TIMException {
        String api = "v4/group_open_http_svc/send_group_system_notification";

        Map map = new HashMap<>(5);
        map.put("GroupId", groupId);
        map.put("Content", message);
        if (CollectionUtils.isNotEmpty(toMembers)) {
            map.put("ToMembers_Account", toMembers);
        }
        this.timService.post(api, map);
    }

    @Override
    public void sendGroupSystemNotification(String groupId, String message) throws TIMException {
        this.sendGroupSystemNotification(groupId, null, message);
    }

    @Override
    public AddGroupResult importGroupMember(String groupId, List<ImportMember> members) throws TIMException {
        String api = "v4/group_open_http_svc/import_group_member";
        Map map = new HashMap<>(3);
        map.put("GroupId", groupId);
        map.put("MemberList", members);
        return JsonUtils.fromJson(this.timService.post(api, map), AddGroupResult.class);
    }


}
