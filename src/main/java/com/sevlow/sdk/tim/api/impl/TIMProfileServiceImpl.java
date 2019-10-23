package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMProfileService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.bean.SnsItem;
import com.sevlow.sdk.tim.bean.chat.ChatMsgEnum;
import com.sevlow.sdk.tim.bean.chat.MsgBody;
import com.sevlow.sdk.tim.bean.chat.MsgContent;
import com.sevlow.sdk.tim.bean.profile.GenderEnum;
import com.sevlow.sdk.tim.bean.profile.TIMProfile;
import com.sevlow.sdk.tim.common.error.TIMError;
import com.sevlow.sdk.tim.common.error.TIMException;
import com.sevlow.sdk.tim.constant.TIMErrorConstant;
import com.sevlow.sdk.tim.utils.JsonUtils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean2;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author pengshiqing
 * @Date: 2019/7/26
 * @Description:
 */
@Slf4j
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
    public void setInfoGender(String identifier, GenderEnum genderEnum) throws TIMException {
        if (identifier == null) {
            throw new TIMException(new TIMError(40003, "用户账号不存在"));
        }
        if (genderEnum == null) {
            genderEnum = GenderEnum.Female;
        }
        String api = "v4/profile/portrait_set";

        Map<String, Object> body = new HashMap<>(4);

        body.put("From_Account", identifier);

        List<SnsItem<String>> list = new ArrayList<>();

        SnsItem<String> snsItem = new SnsItem<>();
        snsItem.setTag("Tag_Profile_IM_Gender");
        snsItem.setValue(genderEnum.getType());

        list.add(snsItem);
        body.put("ProfileItem", list);

        this.timService.post(api, body);
    }

    @Override
    public void setPortrait(@NonNull String identifier, TIMProfile imProfile, Map<String, Object> customProfile) throws TIMException {

        if (identifier == null) {
            throw new TIMException(new TIMError(50001, TIMErrorConstant.getErrorInfo(50001)));
        }

        List<SnsItem> profileItemList = new ArrayList<>();

        if (imProfile != null) {
            try {
//                Map<String, Object> imProfileMap = BeanUtils.describe(imProfile);

                String jsonStr = JsonUtils.toJson(imProfile);
                Map<String,Object> imProfileMap = JsonUtils.fromJson(jsonStr,new HashMap().getClass());

                for (Map.Entry<String, Object> entity : imProfileMap.entrySet()) {
                    profileItemList.add(new SnsItem(entity.getKey(), entity.getValue()));
                }
            } catch (Exception e) {
                throw new TIMException(new TIMError(40001, TIMErrorConstant.getErrorInfo(40001)));
            }
        }

        if (customProfile != null) {
            String key;
            String CUSTOM_PROFILE_PREFIX = "Tag_Profile_Custom_";
            for (Map.Entry<String, Object> entity : customProfile.entrySet()) {
                key = entity.getKey();
                if (key.length() > 8) {
                    throw new TIMException(new TIMError(-1, "自定义资料字段不能超过8个字符"));
                }
                key = CUSTOM_PROFILE_PREFIX.concat(key);
                profileItemList.add(new SnsItem(key, entity.getValue()));
            }
        }

        if (profileItemList.size() < 1) {
            log.warn("当前未设置任何资料，不进行接口请求");
            return ;
        }

        String api = "v4/profile/portrait_set";
        Map<String, Object> body = new HashMap<>(4);
        body.put("From_Account", identifier);
        body.put("ProfileItem", profileItemList);

        this.timService.post(api, body);

    }

    @Override
    public void setPortrait(@NonNull String identifier, TIMProfile imProfile) throws TIMException {
        this.setPortrait(identifier, imProfile, null);
    }

    @Override
    public void setPortrait(@NonNull String identifier, Map<String, Object> customProfile) throws TIMException {
        this.setPortrait(identifier, null, customProfile);
    }

    /**
     * 设置自定义字段和标配字段 map的key为标配或者自定义的key，
     * 标配字段key 如Tag_Profile_IM_Gender不能简写
     * 自定义字段key 如 Tag_Profile_Custom_Test不能简写并且需要提前在im后台设置好
     */
//    @Override
//    public void setInfoGender(String identifier, Map<String, String> map) throws TIMException {
//        if (identifier == null) {
//            throw new TIMException(new TIMError(5000, "用户账号不存在"));
//        }
//
//        if (map == null || map.keySet().size() == 0) {
//            throw new TIMException(new TIMError(5000, "设置属性不能全部为空"));
//        }
//
//        String api = "v4/profile/portrait_set";
//
//        Map<String, Object> body = new HashMap<>(4);
//
//        body.put("From_Account", identifier);
//
//        List<SnsItem<String>> list = new ArrayList<>();
//
//        // 自定义
//        Set<String> keySet = map.keySet();
//
//        for (String key : keySet) {
//            SnsItem<String> snsItem = new SnsItem<>();
//            snsItem.setTag(key);
//            snsItem.setValue(map.get(key));
//            list.add(snsItem);
//        }
//
//        body.put("ProfileItem", list);
//
//        this.timService.post(api, body);
//
//    }
}
