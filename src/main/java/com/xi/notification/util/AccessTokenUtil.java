package com.xi.notification.util;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;
import com.xi.notification.config.DingDingConfig;
import com.xi.notification.enums.DingApiUrlEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2020/12/1
 */
@Component
public class AccessTokenUtil {

    @Autowired
    private DingDingConfig dingDingConfig;

    public String getToken() throws RuntimeException {
        try {
            DefaultDingTalkClient client = new DefaultDingTalkClient(DingApiUrlEnum.URL_GET_TOKKEN.getUrl());
            OapiGettokenRequest request = new OapiGettokenRequest();

            request.setAppkey(dingDingConfig.getAppKey());
            request.setAppsecret(dingDingConfig.getAppSecret());
            request.setHttpMethod("GET");
            OapiGettokenResponse response = client.execute(request);
            String accessToken = response.getAccessToken();
            return accessToken;
        } catch (ApiException e) {
            //bizLogger.error("getAccessToken failed", e);
            throw new RuntimeException();
        }
    }
}
