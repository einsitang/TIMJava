package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMProfileService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.bean.SnsItem;
import com.sevlow.sdk.tim.bean.chat.ChatMsgEnum;
import com.sevlow.sdk.tim.bean.chat.MsgBody;
import com.sevlow.sdk.tim.bean.chat.MsgContent;
import com.sevlow.sdk.tim.bean.profile.GenderEnum;
import com.sevlow.sdk.tim.common.error.TIMError;
import com.sevlow.sdk.tim.common.error.TIMException;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengshiqing
 * @Date: 2019/7/26
 * @Description:
 */
public class TIMProfileServiceImpl implements TIMProfileService {

    private TIMService timService;

    public TIMProfileServiceImpl(TIMService timService) {
        this.timService = timService;
    }



    /**
     * 设置性别
     *
     * @param identifier
     * @param genderEnum
     */
    @Override
    public void setInfoGender(String identifier, GenderEnum genderEnum) throws TIMException{
        if (identifier == null ) {
            throw new TIMException(new TIMError(40003,"用户账号不存在"));
        }
        if (genderEnum == null){
            genderEnum = GenderEnum.Female ;
        }
        String api = "v4/profile/portrait_set";

        Map<String, Object> body = new HashMap<>(4);

        body.put("From_Account", identifier);

        List<SnsItem<String>> list = new ArrayList<>();

        SnsItem<String> snsItem = new SnsItem<>();
        snsItem.setTag("Tag_Profile_IM_Gender");
        snsItem.setValue(genderEnum.getType());

        list.add(snsItem);
        body.put("ProfileItem",list);

        this.timService.post(api, body);
    }
}
