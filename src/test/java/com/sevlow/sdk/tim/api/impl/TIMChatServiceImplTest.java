package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMChatService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.api.test.TestModule;
import com.sevlow.sdk.tim.common.error.TIMException;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;


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
    public void testBatchSendMsg() throws TimeoutException, TIMException {

        String fromAccount = "admin" ;

        List toAccount = Arrays.asList("test_211","test_3");

        List<String> msg = Arrays.asList("你好");

        chatService.batchSendMsg(fromAccount,toAccount,msg);

    }
}