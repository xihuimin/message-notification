package com.xi.notification.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiChatSendRequest;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.request.OapiMessageSendToConversationRequest;
import com.dingtalk.api.response.OapiChatSendResponse;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.dingtalk.api.response.OapiMessageSendToConversationResponse;
import com.taobao.api.ApiException;
import com.xi.notification.config.DingDingConfig;
import com.xi.notification.enums.DingApiUrlEnum;
import com.xi.notification.enums.DingMsgTypeEnum;
import com.xi.notification.util.AccessTokenUtil;
import com.xi.notification.util.MessageDispenseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2020/12/1
 */
@Component
public class NotifyMessageImpl {

    @Autowired
    private DingDingConfig dingDingConfig;

    @Autowired
    private MessageDispenseUtil messageDispenseUtil;

    @Autowired
    private AccessTokenUtil accessTokenUtil;

    /**
     * 发送工作通知
     */
    public void sendJobMessage(String userId, DingMsgTypeEnum type, String content) throws ApiException {
        DingTalkClient client = new
                DefaultDingTalkClient(DingApiUrlEnum.URL_SEND_JOB_MESSAGE.getUrl());
        OapiMessageCorpconversationAsyncsendV2Request request = new
                OapiMessageCorpconversationAsyncsendV2Request();
        if (userId == null){
            request.setToAllUser(true);
        }else {
            request.setUseridList(userId);
        }
        request.setAgentId(dingDingConfig.getAgentId());

        switch (type){
            case TEXT:
                messageDispenseUtil.sendText(request, content);
                break;
            case IMAGE:
                break;
            case FILE:
                break;
            case MARKDOWN:
                messageDispenseUtil.sendMarkdown(request, content);
                break;
            case OA:
                break;
            case ACTION_CARD:
                break;
            default:
                throw new IllegalArgumentException();
        }
        OapiMessageCorpconversationAsyncsendV2Response response =
                client.execute(request, accessTokenUtil.getToken());
        if (response.isSuccess()){
            // 记录发送的工作通知
            //saveMessageLog(response);
            System.out.println(response.getTaskId());
        }
    }

    /**
     * 发送群消息
     * @param chatId
     * @param type
     * @param content
     */
    public void sendGroupMessage(String chatId, DingMsgTypeEnum type, String content) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(DingApiUrlEnum.URL_SEND_GROUP_MESSAGE.getUrl());
        OapiChatSendRequest request = new OapiChatSendRequest();
        request.setChatid(chatId);
        switch (type){
            case TEXT:
                messageDispenseUtil.sendText(request, content);
                break;
            case IMAGE:
                break;
            case FILE:
                break;
            case MARKDOWN:
                break;
            case OA:
                break;
            case ACTION_CARD:
                break;
            default:
                throw new IllegalArgumentException();
        }
        OapiChatSendResponse response =
                client.execute(request, accessTokenUtil.getToken());
        if (response.isSuccess()){
            // 记录群消息
            //saveMessageLog(response);
            System.out.println(response.getMessageId());
        }
    }

    public void sendOrdinaryMessage(String cid, String sender, DingMsgTypeEnum type, String content) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(DingApiUrlEnum.URL_SEND_ORDINARY_MESSAGE.getUrl());
        OapiMessageSendToConversationRequest request = new OapiMessageSendToConversationRequest();
        request.setSender(sender);
        request.setCid(cid);
        switch (type){
            case TEXT:
                messageDispenseUtil.sendText(request, content);
                break;
            case IMAGE:
                break;
            case FILE:
                break;
            case MARKDOWN:
                break;
            case OA:
                break;
            case ACTION_CARD:
                break;
            default:
                throw new IllegalArgumentException();
        }
        OapiMessageSendToConversationResponse response =
                client.execute(request, accessTokenUtil.getToken());
        if (response.isSuccess()){
            // 记录发送群消息
            //saveMessageLog(response);
            System.out.println(response.getReceiver());
        }
    }
}
