package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.*;
import com.sevlow.sdk.tim.common.TLSSigature;
import com.sevlow.sdk.tim.common.error.TIMError;
import com.sevlow.sdk.tim.common.error.TIMException;
import com.sevlow.sdk.tim.config.TIMConfig;
import com.sevlow.sdk.tim.utils.JsonUtils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RegExUtils;

import java.io.File;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.Map;


/**
 * @author element
 */
@Slf4j
public class TIMServiceImpl implements TIMService {

    private TIMConfig config;

    private String priKey = null;

    private final OkHttpClient HTTP_CLIENT = new OkHttpClient();
    private final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private TIMAccountService accountService = new TIMAccountServiceImpl(this);
    private TIMOnlineStatusService onlineStatusService = new TIMOnlineStatusServiceImpl(this);
    private TIMRelationService relationService = new TIMRelationServiceImpl(this);
    private TIMChatService chatService = new TIMChatServiceImpl(this);
    private TIMProfileService profileService = new TIMProfileServiceImpl(this);
    private TIMGroupServiceImpl groupService = new TIMGroupServiceImpl(this);
    private TIMOperationalService operationalService = null;
    private TIMDirtyWordService dirtyWordService = null;
    private TIMNoSpeakService noSpeakService = null;

    public TIMServiceImpl(TIMConfig config) {
        this.config = config;
    }

    @Override
    public TIMConfig getConfig() {
        return this.config;
    }

    @Override
    public String getUserSig(@NonNull String identifier) throws TIMException {
        return getUserSig(identifier, 30);
    }

    @Override
    public String getUserSig(@NonNull String identifier, Integer expireOfDay) throws TIMException {
        TLSSigature.GenTLSSignatureResult signatureResult;

        if (expireOfDay == null) {
            expireOfDay = 30;
        }
        if (expireOfDay < 1) {
            expireOfDay = 1;
        }

        try {

            if (priKey == null) {

                final String CLASSPATH_PREFIX = "classpath:";

                if (config.getPrivateKeyPath().startsWith(CLASSPATH_PREFIX)) {
                    InputStream fis = TIMConfig.class.getClassLoader().getResourceAsStream(RegExUtils.removeFirst(config.getPrivateKeyPath(), CLASSPATH_PREFIX));
                    priKey = IOUtils.toString(fis, "UTF-8");
                } else {
                    priKey = FileUtils.readFileToString(new File(config.getPrivateKeyPath()), "UTF-8");
                }

            }

            int secondOfMonth = 60 * 60 * 24 * expireOfDay;
            signatureResult = TLSSigature.GenTLSSignatureEx(config.getAppId(), identifier, priKey, secondOfMonth);
            if (signatureResult == null || signatureResult.urlSig == null) {
                throw new TIMException(new TIMError(-1, "UserSig生成失败"));
            }

        } catch (TIMException e) {
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new TIMException(new TIMError(-1, e.getClass().getName() + " >> " + e.getMessage()));
        }

        return signatureResult.urlSig;
    }

    @Override
    public String get(String api, Map<String, String> queryParams) throws TIMException {

        String url = buildFullUrl(api, queryParams);

        log.debug("【TIMJava】 request method : {}", "GET");
        log.debug("【TIMJava】 request url : {}", url);

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        return execute(request);
    }

    @Override
    public String post(String api, Object body) throws TIMException {

        String url = buildFullUrl(api, null);
        String json = JsonUtils.toJson(body);

        log.debug("【TIMJava】 request method : {}", "POST");
        log.debug("【TIMJava】 request url : {}", url);
        log.debug("【TIMJava】 request body : {}", json);

        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSON, json))
                .build();

        return execute(request);
    }

    private static final String CONTENT_TYPE = "json";
    private static final String URL = "https://console.tim.qq.com";

    private String buildFullUrl(String api, Map<String, String> queryParams) throws TIMException {
        Long appid = this.getConfig().getAppId();
        String adminIdentifier = this.getConfig().getAdminIdentifier();
        String userSig = this.getUserSig(adminIdentifier);
        String randomText = (Math.random() * 10000000 + "").substring(0, 8);

        String urlTemplate = URL + "/" + api + "?sdkappid=%s&identifier=%s&usersig=%s&random=%s&contenttype=%s";

        String url = String.format(urlTemplate, appid, adminIdentifier, userSig, randomText, CONTENT_TYPE);

        if (queryParams != null) {
            Iterator<Map.Entry<String, String>> iterator = queryParams.entrySet().iterator();
            Map.Entry<String, String> entry;
            while (iterator.hasNext()) {
                entry = iterator.next();
                url += "&" + entry.getKey() + "=" + entry.getValue();
            }
        }

        return url;
    }

    private String executeInternal(Request request) throws Exception {

        Response response = HTTP_CLIENT.newCall(request).execute();
        String jsonResult = response.body().string();

        TIMError timError = JsonUtils.fromJson(jsonResult, TIMError.class);

        if (0 != timError.getErrorCode()) {
            throw new TIMException(timError);
        }

        log.debug("【TIMJava】response body -------- ");
        log.debug(jsonResult);
        log.debug("【TIMJava】response body -------- ");

        return jsonResult;

    }

    private String execute(Request request) throws TIMException {
        return execute(request, 1);
    }

    private String execute(Request request, int reqCount) throws TIMException {
        try {

            log.debug("【TIMJava】 发起请求 当前第 {} 次 / {} 次 {}", reqCount, config.getReqMaxRetry(), reqCount > 1 ? "[重试请求]" : "");

            return executeInternal(request);

        } catch (SocketTimeoutException e) {

            if (reqCount >= config.getReqMaxRetry()) {
                throw new TIMException(new TIMError(-1, "请求失效,请检查你的网络状态"));
            }

            // 执行重试
            return execute(request, reqCount++);

        } catch (TIMException e) {
            throw e;
        } catch (Exception e) {
            throw new TIMException(new TIMError(-1, e.getMessage()));
        }
    }

    @Override
    public TIMAccountService getAccountService() {
        return this.accountService;
    }


    @Override
    public TIMDirtyWordService getDirtyWordService() {
        return this.dirtyWordService;
    }

    @Override
    public TIMGroupService getGroupService() {
        return this.groupService;
    }

    @Override
    public TIMNoSpeakService getNoSpeakService() {
        return this.noSpeakService;
    }

    @Override
    public TIMOnlineStatusService getOnlineStatusService() {
        return this.onlineStatusService;
    }

    @Override
    public TIMOperationalService getOperationalService() {
        return this.operationalService;
    }

    @Override
    public TIMProfileService getProfileService() {
        return this.profileService;
    }

    @Override
    public TIMRelationService getRelationService() {
        return this.relationService;
    }

    @Override
    public TIMChatService getChatService() {
        return this.chatService;
    }

}
