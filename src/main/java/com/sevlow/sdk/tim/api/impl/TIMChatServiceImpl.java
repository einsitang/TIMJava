package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMChatService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.bean.chat.MsgBody;
import com.sevlow.sdk.tim.bean.chat.MsgContent;
import com.sevlow.sdk.tim.common.error.TIMException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

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
    public void batchsendmsg(String fromAccount, List<String> toAccounts, List<String> msgList) throws TimeoutException, TIMException {
        if (toAccounts == null || toAccounts.size() > 500) {
            throw new TimeoutException("群发账号不能多于500个");
        }

        String api = "/v4/openim/batchsendmsg";

        Map<String, Object> body = new HashMap<>();
        body.put("SyncOtherMachine", 2);
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
}
