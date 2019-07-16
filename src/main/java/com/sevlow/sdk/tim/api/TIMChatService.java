package com.sevlow.sdk.tim.api;

import com.sevlow.sdk.tim.common.error.TIMException;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.api
 * @date 2019-05-27 10:33
 * @Description:
 * 单聊消息
 * API Doc :  https://cloud.tencent.com/document/product/269/1610
 *
 */
public interface TIMChatService {

    /**
     * 批量消息
     *  @param fromAccount 指定发送账号
     *  @param toAccounts 群发接收账号集合
     *  @param msgList 消息集合
     */
    void batchSendMsg(String fromAccount , List<String> toAccounts,List<String> msgList) throws TIMException;
}
