package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.api.test.TestModule;
import com.sevlow.sdk.tim.common.error.TIMException;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;

/**
 * TIMService 测试用例
 *
 * @author element
 */
@Slf4j
@Guice(modules = {TestModule.class})
public class TIMServiceImplTest {

    @Inject
    private TIMService timService;

    @Test
    public void testGetUserSig() {

        String identifier = "test";

        try {
            String userSig = timService.getUserSig(identifier);

            log.debug("userSig");
            log.debug(userSig);

        } catch (TIMException e) {
            log.error(e.getMessage(), e);
        }
    }
}

