package com.sevlow.sdk.tim.api;

import com.sevlow.sdk.tim.bean.chat.ChatMsgEnum;
import com.sevlow.sdk.tim.bean.chat.MsgCustomContent;
import com.sevlow.sdk.tim.common.error.TIMException;
import lombok.NonNull;

import java.util.List;


/**
 * @author Element
 *
 * 单聊消息
 * API Doc :  https://cloud.tencent.com/document/product/269/1610
 *
 */
public interface TIMChatService {

    /**
     * 批量文本消息
     *  @param fromAccount 指定发送账号
     *  @param toAccounts 群发接收账号集合
     *  @param msgList 消息集合
     */
    void batchSendTextMsg(String fromAccount , List<String> toAccounts,List<String> msgList) throws TIMException;
    void batchSendTextMsg(String fromAccount , List<String> toAccounts, List<String> msgList, ChatMsgEnum msgEnum) throws TIMException;


    /**
     * 批量自定义消息
     *  @param fromAccount 指定发送账号
     *  @param toAccounts 群发接收账号集合
     *  @param msgCustomContent 消息集合
     */
    void batchSendCustomMsg(String fromAccount , List<String> toAccounts,@NonNull MsgCustomContent msgCustomContent) throws TIMException;
    void batchSendCustomMsg(String fromAccount , List<String> toAccounts,@NonNull MsgCustomContent msgCustomContent,ChatMsgEnum msgEnum) throws TIMException;


    /**
     * 发送单聊文本消息
     *  @param fromAccount 指定发送账号
     *  @param toAccount 群发接收账号
     *  @param msgList 消息集合
     */
    void sendTextMsg(String fromAccount , String toAccount,List<String> msgList) throws TIMException;
    void sendTextMsg(String fromAccount , String toAccount,List<String> msgList,ChatMsgEnum msgEnum) throws TIMException;

    /**
     * 发送单聊自定义消息
     *  @param fromAccount 指定发送账号
     *  @param toAccount 群发接收账号集合
     *  @param msgCustomContent 消息
     */
    void sendCustomMsg(@NonNull String fromAccount , @NonNull String toAccount, @NonNull MsgCustomContent msgCustomContent) throws TIMException;
    void sendCustomMsg(@NonNull String fromAccount , @NonNull String toAccount, @NonNull MsgCustomContent msgCustomContent,ChatMsgEnum msgEnum) throws TIMException;



}
