package com.sevlow.sdk.tim.api;

import com.sevlow.sdk.tim.bean.chat.MsgCustomContent;
import com.sevlow.sdk.tim.bean.group.*;
import com.sevlow.sdk.tim.common.error.TIMException;

import java.util.List;

/**
 * @author Element
 *
 * 群组管理
 * API Doc : https://cloud.tencent.com/document/product/269/1613
 */
public interface TIMGroupService {

    /**
     * 获取所有的群
     *
     * @param type  群组类型
     * @return
     * @throws TIMException
     */
    AllGroupResult getAllGroup(GroupInfo.Type type) throws TIMException;

    /**
     * 分页获取群信息
     *
     * @param next
     * @param limit
     * @param type
     * @return
     * @throws TIMException
     */
    AllGroupResult pageGroup(int next, int limit, GroupInfo.Type type) throws TIMException;

    /**
     * 创建群
     *
     * @param groupInfo
     * @return
     * @throws TIMException
     */
    CreateGroupResult createGroup(GroupInfo groupInfo) throws TIMException;


    /**
     * 修改群资料
     *
     * @param groupInfo
     * @throws TIMException
     */
    void updateGroup(GroupInfo groupInfo) throws TIMException;


    /**
     * 增加群组成员
     *
     * @param groupId
     * @param members
     * @param silenceEnum 静默模式,设置加群后是否下发系统通知。
     * @return
     * @throws TIMException
     */
    AddGroupResult addGroupMember(String groupId, List<String> members, SilenceEnum silenceEnum) throws TIMException;

    /**
     * 增加群组成员
     * 默认静默模式 : SilenceEnum.QUIET
     *
     * @param groupId
     * @param members
     * @return
     * @throws TIMException
     */
    AddGroupResult addGroupMember(String groupId, List<String> members) throws TIMException;

    /**
     * 删除群成员
     *
     * @param groupId
     * @param members
     * @param silenceEnum 静默模式,设置离群后是否下发系统通知。
     * @param reason
     * @throws TIMException
     */
    void deleteGroupMember(String groupId, List<String> members, SilenceEnum silenceEnum, String reason) throws TIMException;


    /**
     * 设置群成员资料
     *
     * @param groupMemberInfo
     * @throws TIMException
     */
    void modifyGroupMemberInfo(GroupMemberInfo groupMemberInfo) throws TIMException;


    /**
     * 解散群
     *
     * @param groupId
     * @throws TIMException
     */
    void destroyGroup(String groupId) throws TIMException;


    /**
     * 批量禁言和取消禁言
     *
     * @param groupId
     * @param members
     * @param time    禁言时间 <=0：取消禁言
     * @throws TIMException
     */
    void forbidSendMsg(String groupId, List<String> members, int time) throws TIMException;


    /**
     * 获取群组被禁言用户列表
     *
     * @param groupId
     * @return
     * @throws TIMException
     */
    ShuttedMemberResult getShuttedMember(String groupId) throws TIMException;

    /**
     * 发送群普通消息
     *
     * @param groupId
     * @param account
     * @param isSentOnline true 则消息表示只在线下发，不存离线和漫游（AVChatRoom 和 BChatRoom 不允许使用）。
     * @param message      文本消息
     * @throws TIMException
     */
    void sendGroupMsg(String groupId, String account, Boolean isSentOnline, String message) throws TIMException;

    /**
     *  发送自定义消息
     * @param groupId
     * @param account
     * @param isSentOnline true 则消息表示只在线下发，不存离线和漫游（AVChatRoom 和 BChatRoom 不允许使用）。
     * @param message 自定义消息内容
     */
    void sentGroupCustomMsg(String groupId, String account, Boolean isSentOnline, MsgCustomContent message) throws TIMException;

    /**
     * 发送通知消息
     *
     * @param toMembers 如果为空或者null，发送所有人
     */
    void sendGroupSystemNotification(String groupId, List<String> toMembers, String message) throws TIMException;

    /**
     * 发送所有人通知消息
     * @param groupId
     * @param message
     * @throws TIMException
     */
    void sendGroupSystemNotification(String groupId, String message) throws TIMException;

    /**
     * @param groupId
     * @param members
     * @return
     * @throws TIMException
     */
    AddGroupResult importGroupMember(String groupId, List<ImportMember> members) throws TIMException;


}
