package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMChatService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.api.test.TestModule;
import com.sevlow.sdk.tim.bean.chat.MsgCustomContent;
import com.sevlow.sdk.tim.common.error.TIMException;
import com.sevlow.sdk.tim.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author pengshiqing
 * @Date: 2019/7/16
 * @Description:
 */

@Slf4j
@Guice(modules = {TestModule.class})
public class TIMChatServiceImplTest {

    @Inject
    private TIMService timService;

    private TIMChatService chatService;


    @BeforeTest
    public void before() {
        this.chatService = timService.getChatService();
    }


    @Test
    public void testBatchSendMsg() throws TIMException {

        String fromAccount = "admin" ;

        List toAccount = Arrays.asList("test_211","test_3","sssddasdfewrfew");

        List<String> msg = Arrays.asList("你好");

        chatService.batchSendTextMsg(fromAccount,toAccount,msg);

    }

    @Test
    public void testSendTextMsg() throws TIMException {
        String fromAccount = "69887072709640192" ;
        String toAccount = "71243920540958720";
        List<String> msg = Arrays.asList("你好");
        chatService.sendTextMsg(fromAccount,toAccount,msg);

    }

    @Test
    public void textSendCustomMsg() throws TIMException {
        String fromAccount = "69887072709640192" ;
        String toAccount = "71243920540958720";
        Map<String,String> map = new HashMap<>();

        Map<String,String> data = new HashMap<>();
        data.put("money","10");
        data.put("userId","123456789");

        MsgCustomContent msg = new MsgCustomContent();
        msg.setData(JsonUtils.toJson(data));
        msg.setDesc("hello");
        msg.setExt("www.qq.com");
        msg.setSound("dingdong.aiff");
        chatService.sendCustomMsg(fromAccount,toAccount,msg);
    }
}