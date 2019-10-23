package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMChatService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.bean.chat.ChatMsgEnum;
import com.sevlow.sdk.tim.bean.chat.MsgBody;
import com.sevlow.sdk.tim.bean.chat.MsgContent;
import com.sevlow.sdk.tim.bean.chat.MsgCustomContent;
import com.sevlow.sdk.tim.common.error.TIMError;
import com.sevlow.sdk.tim.common.error.TIMException;
import com.sevlow.sdk.tim.constant.TIMErrorConstant;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengshiqing
 * @Date: 2019/7/16
 * @Description:
 */

@Slf4j
public class TIMChatServiceImpl implements TIMChatService {

    private TIMService timService;

    public TIMChatServiceImpl(TIMService timService) {
        this.timService = timService;
    }

    /**
     * 批量消息
     *  @param fromAccount 指定发送账号
     *  @param toAccounts 群发接收账号集合
     *  @param msgList 消息集合
     */
    @Override
    public void batchSendTextMsg(String fromAccount, List<String> toAccounts, List<String> msgList) throws TIMException {
        batchSendTextMsg(fromAccount,toAccounts,msgList,null);
    }

    @Override
    public void batchSendTextMsg(String fromAccount, List<String> toAccounts, List<String> msgList, ChatMsgEnum msgEnum) throws TIMException {
        if (toAccounts == null || toAccounts.size() > 500) {
            throw new TIMException(new TIMError(90011, TIMErrorConstant.getErrorInfo(90011)));
        }
        if (msgEnum == null){
            msgEnum = ChatMsgEnum.SYNC ;
        }
        String api = "v4/openim/batchsendmsg";

        Map<String, Object> body = new HashMap<>(4);
        body.put("SyncOtherMachine", msgEnum.getType());
        body.put("From_Account",fromAccount);
        body.put("To_Account",toAccounts);
        body.put("MsgRandom", RandomUtils.nextInt(10000000,99999999));

        List<MsgBody> msgBodies = new ArrayList<>();

        for (String msg : msgList) {
            MsgBody msgBody = new MsgBody();
            msgBody.setMsgType("TIMTextElem");
            msgBody.setMsgContent(new MsgContent(msg));
            msgBodies.add(msgBody);
        }
        body.put("MsgBody",msgBodies);

        this.timService.post(api, body);
    }

    /**
     * 批量自定义消息
     *
     * @param fromAccount      指定发送账号
     * @param toAccounts       群发接收账号集合
     * @param msgCustomContent 消息集合
     */
    @Override
    public void batchSendCustomMsg(String fromAccount, List<String> toAccounts, @NonNull MsgCustomContent msgCustomContent) throws TIMException {
        batchSendCustomMsg(fromAccount,toAccounts,msgCustomContent,null);
    }

    @Override
    public void batchSendCustomMsg(String fromAccount, List<String> toAccounts, @NonNull MsgCustomContent msgCustomContent, ChatMsgEnum msgEnum) throws TIMException {
        if (toAccounts == null || toAccounts.size() > 500) {
            throw new TIMException(new TIMError(90011, TIMErrorConstant.getErrorInfo(90011)));
        }

        if (msgEnum == null){
            msgEnum = ChatMsgEnum.SYNC ;
        }

        String api = "v4/openim/batchsendmsg";

        Map<String, Object> body = new HashMap<>(4);
        body.put("SyncOtherMachine", msgEnum.getType());
        body.put("From_Account",fromAccount);
        body.put("To_Account",toAccounts);
        body.put("MsgRandom", RandomUtils.nextInt(10000000,99999999));

        List<MsgBody> msgBodies = new ArrayList<>();

        MsgBody msgBody = new MsgBody();
        msgBody.setMsgType("TIMCustomElem");
        msgBody.setMsgContent(msgCustomContent);

        msgBodies.add(msgBody);

        body.put("MsgBody",msgBodies);

        this.timService.post(api, body);
    }

    /**
     * 发送单聊消息
     *
     * @param fromAccount 指定发送账号
     * @param toAccount  群发接收账号集合
     * @param msgList     消息集合
     */
    @Override
    public void sendTextMsg(String fromAccount, String toAccount, List<String> msgList) throws TIMException {
        sendTextMsg(fromAccount,toAccount,msgList,null);
    }

    @Override
    public void sendTextMsg(String fromAccount, String toAccount, List<String> msgList, ChatMsgEnum msgEnum) throws TIMException {
        String api = "v4/openim/sendmsg";

        if (msgEnum == null){
            msgEnum = ChatMsgEnum.SYNC ;
        }

        Map<String, Object> body = new HashMap<>(4);
        body.put("SyncOtherMachine", msgEnum.getType());
        body.put("From_Account",fromAccount);
        body.put("To_Account",toAccount);
        body.put("MsgRandom", RandomUtils.nextInt(10000000,99999999));

        List<MsgBody> msgBodies = new ArrayList<>();

        for (String msg : msgList) {
            MsgBody msgBody = new MsgBody();
            msgBody.setMsgType("TIMTextElem");
            msgBody.setMsgContent(new MsgContent(msg));
            msgBodies.add(msgBody);
        }
        body.put("MsgBody",msgBodies);

        this.timService.post(api, body);
    }

    /**
     * 发送单聊自定义消息
     *
     * @param fromAccount 指定发送账号
     * @param toAccount   群发接收账号集合
     * @param msgCustomContent         消息集合
     */
    @Override
    public void sendCustomMsg(@NonNull String fromAccount, @NonNull String toAccount, @NonNull MsgCustomContent msgCustomContent) throws TIMException {
        sendCustomMsg(fromAccount,toAccount,msgCustomContent,null);
    }

    @Override
    public void sendCustomMsg(@NonNull String fromAccount, @NonNull String toAccount, @NonNull MsgCustomContent msgCustomContent, ChatMsgEnum msgEnum) throws TIMException {
        String api = "v4/openim/sendmsg";

        if (msgEnum == null){
            msgEnum = ChatMsgEnum.SYNC ;
        }

        Map<String, Object> body = new HashMap<>(4);
        body.put("SyncOtherMachine", msgEnum.getType());
        body.put("From_Account",fromAccount);
        body.put("To_Account",toAccount);
        body.put("MsgRandom", RandomUtils.nextInt(10000000,99999999));

        List<MsgBody> msgBodies = new ArrayList<>();

        MsgBody msgBody = new MsgBody();
        msgBody.setMsgType("TIMCustomElem");
        msgBody.setMsgContent(msgCustomContent);
        msgBodies.add(msgBody);
        body.put("MsgBody",msgBodies);

        this.timService.post(api, body);
    }


}
