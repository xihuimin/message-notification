package com.xi.notification.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiV2UserGetbymobileRequest;
import com.dingtalk.api.response.OapiV2UserGetbymobileResponse;
import com.taobao.api.ApiException;
import com.xi.notification.enums.DingApiUrlEnum;
import com.xi.notification.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2020/12/1
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getUserId(String accessToken, String mobile) {
        try {
            DingTalkClient client = new DefaultDingTalkClient(DingApiUrlEnum.URL_GET_USERID.getUrl());
            OapiV2UserGetbymobileRequest request = new OapiV2UserGetbymobileRequest();
            request.setMobile(mobile);
            OapiV2UserGetbymobileResponse response = client.execute(request, accessToken);
            if (response.isSuccess()){
                return response.getResult().getUserid();
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }
}
