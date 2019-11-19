package com.sevlow.sdk.tim.api;

import com.sevlow.sdk.tim.bean.group.*;
import com.sevlow.sdk.tim.common.error.TIMException;

import java.util.List;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.api
 * @date 2019-05-27 11:13
 * @Description:
 * 群组管理
 * API Doc : https://cloud.tencent.com/document/product/269/1613
 */
public interface TIMGroupService {

    /**
     *  获取所有的群
     */
    AllGroupResult getAllGroup(GroupInfo.Type type) throws TIMException;

    /**
     *  分页
     */
    AllGroupResult pageGroup(int next, int limit, GroupInfo.Type type) throws TIMException;

    /**
     *  创建群
     */
    CreateGroupResult createGroup(GroupInfo groupInfo) throws TIMException;
    
    /**
     *  修改群资料
     */
    void updateGroup(GroupInfo groupInfo) throws TIMException;

    /**
     *  加入群
     */
    AddGroupResult addGroupMember(String groupId, List<String> members,SilenceEnum silenceEnum) throws TIMException;

    /**
     *  删除群成员
     */
    void deleteGroupMember(String groupId, List<String> members, SilenceEnum silenceEnum, String reason) throws TIMException;
    
    
    /**
     *  设置群成员资料
     */
    void modifyGroupMemberInfo(GroupMemberInfo groupMemberInfo) throws TIMException;


    /**
     *  解散群
     */
    void destroyGroup(String groupId) throws TIMException;


    /**
     *  批量禁言和取消禁言
     * @param time 禁言时间 <=0：取消禁言
     */
    void forbidSendMsg(String groupId,List<String> members, int time) throws TIMException;

    /**
     *  获取群组被禁言用户列表
     */
    ShuttedMember getShuttedMember(String groupId) throws TIMException;

    /**
     *  发送群普通消息
     */
    void sendGroupMsg(String groupId, String account, Boolean isSentOnline, String message) throws TIMException;

    /**
     *  发送通知消息
     * @param toMembers 如果为空或者null，发送所有人
     */
    void sendGroupSystemNotification(String groupId,List<String> toMembers,String message) throws TIMException;

    /**
     *  导入群成员
     */
    AddGroupResult importGroupMember(String groupId,List<ImportMember> members) throws TIMException;


}
