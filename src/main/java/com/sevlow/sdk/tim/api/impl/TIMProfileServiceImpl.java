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
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

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
    

    /**
     *  设置自定义字段和标配字段 map的key为标配或者自定义的key，
     *      标配字段key 如Tag_Profile_IM_Gender不能简写
     *      自定义字段key 如 Tag_Profile_Custom_Test不能简写并且需要提前在im后台设置好
     */
    @Override
    public void setInfoGender(String identifier, Map<String, String> map) throws TIMException {
        if (identifier == null ) {
            throw new TIMException(new TIMError(5000,"用户账号不存在"));
        }

        if ( map == null || map.keySet().size() == 0 ) {
            throw new TIMException(new TIMError(5000,"设置属性不能全部为空"));
        }

        String api = "v4/profile/portrait_set";

        Map<String, Object> body = new HashMap<>(4);

        body.put("From_Account", identifier);

        List<SnsItem<String>> list = new ArrayList<>();

        // 自定义
        Set<String> keySet = map.keySet();

        for (String key : keySet) {
            SnsItem<String> snsItem = new SnsItem<>();
            snsItem.setTag(key);
            snsItem.setValue(map.get(key));
            list.add(snsItem);
        }

        body.put("ProfileItem",list);

        this.timService.post(api, body);

    }
}
