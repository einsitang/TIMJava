package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMGroupService;
import com.sevlow.sdk.tim.api.TIMService;
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


    /**
     *  获取所有的群
     */
    @Override
    public AllGroupResult getAllGroup(GroupInfo.Type type) throws TIMException {

        Map map = new HashMap(2);

        if (type != null){
            map.put("GroupType",type);
        }
        return this.getGroup(map);
    }

    /**
     * 分页
     */
    @Override
    public AllGroupResult pageGroup(int next, int limit, GroupInfo.Type type) throws TIMException {

        Map map = new HashMap(2);
        map.put("Next",next);
        map.put("Limit",limit);
        if (type != null){
            map.put("GroupType",type);
        }
        return this.getGroup(map);
    }

    AllGroupResult getGroup(Map map) throws TIMException {
        String api = "v4/group_open_http_svc/get_appid_group_list";
        return JsonUtils.fromJson(this.timService.post(api, map), AllGroupResult.class);
    }

    /**
     *  创建群
     */
    @Override
    public CreateGroupResult createGroup(GroupInfo groupInfo) throws TIMException {

        String api = "v4/group_open_http_svc/create_group";

        return JsonUtils.fromJson(this.timService.post(api, groupInfo), CreateGroupResult.class);
    }

    /**
     * 修改群资料
     */
    @Override
    public void updateGroup(GroupInfo groupInfo) throws TIMException {

        String api = "v4/group_open_http_svc/modify_group_base_info";

        this.timService.post(api, groupInfo);
    }

    /**
     * 加入群
     */
    @Override
    public AddGroupResult addGroupMember(String groupId, List<String> members, SilenceEnum silenceEnum) throws TIMException {

        String api = "v4/group_open_http_svc/add_group_member";

        Map map = new HashMap<>(3);
        map.put("GroupId",groupId);
        if (silenceEnum != null){
            map.put("Silence",silenceEnum.getType());
        }

        List<MemberAccount> memberList = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(members)){
            memberList = members.stream().map(MemberAccount::new).collect(Collectors.toList());
        }

        map.put("MemberList",memberList);

        return JsonUtils.fromJson(this.timService.post(api, map), AddGroupResult.class);
    }

    /**
     * 删除群成员
     */
    @Override
    public void deleteGroupMember(String groupId, List<String> members, SilenceEnum silenceEnum, String reason) throws TIMException {
        String api = "v4/group_open_http_svc/delete_group_member";

        Map map = new HashMap<>(3);
        map.put("GroupId",groupId);

        if (silenceEnum != null){
            map.put("Silence",silenceEnum.getType());
        }
        if (StringUtils.isNotBlank(reason)){
            map.put("Reason",reason);
        }
        map.put("MemberToDel_Account",members);
        this.timService.post(api, map);
    }

    /**
     * 设置群成员资料
     */
    @Override
    public void modifyGroupMemberInfo(GroupMemberInfo groupMemberInfo) throws TIMException {
        String api = "v4/group_open_http_svc/modify_group_member_info";
        this.timService.post(api, groupMemberInfo);
    }

    /**
     * 解散群
     */
    @Override
    public void destroyGroup(String groupId) throws TIMException {
        String api = "v4/group_open_http_svc/destroy_group";
        Map map = new HashMap(2);
        map.put("GroupId",groupId);
        this.timService.post(api, map);
    }

    /**
     * 批量禁言和取消禁言
     * @param time    禁言时间 <=0：取消禁言
     */
    @Override
    public void forbidSendMsg(String groupId, List<String> members, int time) throws TIMException {
        String api = "v4/group_open_http_svc/forbid_send_msg";
        Map map = new HashMap(2);
        if (time < 0){
            time = 0;
        }
        map.put("GroupId",groupId);
        map.put("Members_Account",members);
        map.put("ShutUpTime",time);
        this.timService.post(api, map);
    }

    /**
     * 获取群组被禁言用户列表
     */
    @Override
    public ShuttedMember getShuttedMember(String groupId) throws TIMException {
        String api = "v4/group_open_http_svc/get_group_shutted_uin";

        Map map = new HashMap<>(3);
        map.put("GroupId",groupId);
        return JsonUtils.fromJson(this.timService.post(api, map), ShuttedMember.class);
    }

    /**
     * 发送群普通消息
     */
    @Override
    public void sendGroupMsg(String groupId, String account,Boolean isSentOnline, String message) throws TIMException {
        String api = "v4/group_open_http_svc/send_group_msg";

        Map map = new HashMap<>(5);
        map.put("GroupId",groupId);
        if (StringUtils.isNotBlank(account)){
            map.put("From_Account",account);
        }
        if (isSentOnline != null && isSentOnline){
            map.put("OnlineOnlyFlag",1);
        }
        map.put("Random", RandomUtils.nextInt(1000000,10000000));

        map.put("MsgBody", Collections.singletonList(new TIMTextElem(message)));

        this.timService.post(api, map);
    }

    /**
     * 发送通知消息
     * @param toMembers 如果为空或者null，发送所有人

     */
    @Override
    public void sendGroupSystemNotification(String groupId, List<String> toMembers, String message) throws TIMException {
        String api = "v4/group_open_http_svc/send_group_system_notification";

        Map map = new HashMap<>(5);
        map.put("GroupId",groupId);
        map.put("Content",message);
        if (CollectionUtils.isNotEmpty(toMembers)){
            map.put("ToMembers_Account",toMembers);
        }
        this.timService.post(api, map);
    }

    /**
     * 导入群成员
     */
    @Override
    public AddGroupResult importGroupMember(String groupId, List<ImportMember> members) throws TIMException {
        String api = "v4/group_open_http_svc/import_group_member";
        Map map = new HashMap<>(3);
        map.put("GroupId",groupId);
        map.put("MemberList",members);
        return JsonUtils.fromJson(this.timService.post(api, map), AddGroupResult.class);
    }


}
