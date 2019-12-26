package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMChatService;
import com.sevlow.sdk.tim.api.TIMProfileService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.api.test.TestModule;
import com.sevlow.sdk.tim.bean.profile.*;
import com.sevlow.sdk.tim.common.error.TIMException;
import com.sevlow.sdk.tim.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import javax.inject.Inject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * @author pengshiqing
 * @Date: 2019/7/26
 * @Description:
 */

@Slf4j
@Guice(modules = {TestModule.class})
public class TIMProfileServiceImplTest {

    @Inject
    private TIMService timService;

    private TIMProfileService profileService;


    @BeforeTest
    public void before() {
        this.profileService = timService.getProfileService();
    }


    @Test
    public void testSetInfoGender() throws TIMException {

        profileService.setInfoGender("10001", GenderEnum.Female);
        profileService.setInfoGender("10002", GenderEnum.MALE);
    }

    @Test
    public void testSetPortrait() throws TIMException {
        TIMProfile imProfile = new TIMProfile();
        imProfile.setGender(GenderEnum.Female);
        imProfile.setAdminForbidType(AdminForbidTypeEnum.NONE);
        imProfile.setAllowType(AllowTypeEnum.NEED_CONFIRM);

        Map<String, Object> customProfile = new HashMap<>();
        customProfile.put("age", "28");
        customProfile.put("college", "家里蹲");

        profileService.setPortrait("10001", imProfile, customProfile);
    }

    @Test
    public void testSetInfoGender3() throws TIMException {
        Map<String, String> map = new HashMap<>();
        map.put("Tag_Profile_IM_Nick", "你好");
        map.put("Tag_Profile_Custom_age", "10");
//        profileService.setInfoGender("10001", map);

    }

    @Test
    public void testGetPortrait() throws TIMException {
        List<String> accounts = Lists.newArrayList("129333528310579201");
        List<String> profileTags = Lists.newArrayList(TIMProfile.TAG_PROFILE_IM_NICK,TIMProfile.TAG_PROFILE_IM_GENDER,TIMProfile.TAG_PROFILE_IM_IMAGE,TIMProfile.TAG_PROFILE_IM_ALLOWTYPE);
        List<String> customs = Lists.newArrayList("college","age");

        UserProfileResult result = profileService.getPortrait(accounts,profileTags,customs);

        List<UserProfileItem> userProfileItems = result.getUserProfileItems();

        String nickName = null;
        for(UserProfileItem item : userProfileItems){
            nickName = String.valueOf(item.getProfile(TIMProfile.TAG_PROFILE_IM_NICK));
            log.info(item.getToAccount().concat(".nickName : ").concat(nickName));
        }

    }
}