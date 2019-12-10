package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMProfileService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.bean.SnsItem;
import com.sevlow.sdk.tim.bean.profile.GenderEnum;
import com.sevlow.sdk.tim.bean.profile.TIMProfile;
import com.sevlow.sdk.tim.bean.profile.UserProfileResult;
import com.sevlow.sdk.tim.common.error.TIMError;
import com.sevlow.sdk.tim.common.error.TIMException;
import com.sevlow.sdk.tim.constant.TIMErrorConstant;
import com.sevlow.sdk.tim.utils.JsonUtils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengshiqing
 * @Date: 2019/7/26
 * @Description:
 */
@Slf4j
public class TIMProfileServiceImpl implements TIMProfileService {

    private TIMService timService;

    private static final String CUSTOM_PROFILE_PREFIX = "Tag_Profile_Custom_";

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
                String jsonStr = JsonUtils.toJson(imProfile);
                Map<String, Object> imProfileMap = JsonUtils.fromJson(jsonStr, new HashMap().getClass());

                for (Map.Entry<String, Object> entity : imProfileMap.entrySet()) {
                    profileItemList.add(new SnsItem(entity.getKey(), entity.getValue()));
                }
            } catch (Exception e) {
                throw new TIMException(new TIMError(40001, TIMErrorConstant.getErrorInfo(40001)));
            }
        }

        if (customProfile != null) {
            String key;
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
            return;
        }

        String api = "v4/profile/portrait_set";
        Map<String, Object> body = new HashMap<>(2);
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

    @Override
    public UserProfileResult getPortrait(@NonNull List<String> accounts, List<String> profiles, List<String> customProfiles) throws TIMException {
        if (profiles == null && customProfiles == null) {
            throw new TIMException(new TIMError(40001, TIMErrorConstant.getErrorInfo(40001)));
        }

        if (accounts.isEmpty()) {
            throw new TIMException(new TIMError(40002, TIMErrorConstant.getErrorInfo(40002)));
        }

        if (accounts.size() > 100) {
            throw new TIMException(new TIMError(-1, "拉取资料的账号不能超过100个"));
        }

        List<String> tagList = new ArrayList<>();

        if (profiles != null && !profiles.isEmpty()) {
            tagList.addAll(profiles);
        }

        if (customProfiles != null && !customProfiles.isEmpty()) {
            for (String custom : customProfiles) {
                if (custom.length() > 8) {
                    throw new TIMException(new TIMError(-1, "自定义资料字段不能超过8个字符"));
                }
                tagList.add(CUSTOM_PROFILE_PREFIX.concat(custom));
            }
        }

        if (tagList.isEmpty()) {
            throw new TIMException(new TIMError(40001, TIMErrorConstant.getErrorInfo(40001)));
        }

        Map<String, Object> body = new HashMap<>();
        body.put("To_Account", accounts);
        body.put("TagList", tagList);

        String api = "v4/profile/portrait_get";

        return JsonUtils.fromJson(this.timService.post(api, body), UserProfileResult.class);
    }

}
