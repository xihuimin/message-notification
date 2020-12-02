package com.xi.notification.util;

import com.dingtalk.api.request.OapiChatSendRequest;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.request.OapiMessageSendToConversationRequest;
import com.xi.notification.enums.DingMsgTypeEnum;
import org.springframework.stereotype.Component;

/**
 * <p>消息类型分发
 *
 * @Author xihuimin
 * @Date 2020/12/1
 */
@Component
public class MessageDispenseUtil {

    /**
     * 发送普通文本工作通知
     * @param request
     * @param context
     */
    public void sendText(OapiMessageCorpconversationAsyncsendV2Request request, String context){
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new
                OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setMsgtype(DingMsgTypeEnum.TEXT.getType());
        msg.setText(new OapiMessageCorpconversationAsyncsendV2Request.Text());
        msg.getText().setContent(context);
        request.setMsg(msg);
    }

    /**
     * 发送普通文本群消息
     * @param request
     * @param context
     */
    public void sendText(OapiChatSendRequest request, String context){
        request.setMsg(DingMsgTypeEnum.TEXT.getType());
        OapiChatSendRequest.Msg msg = new OapiChatSendRequest.Msg();
        msg.setMsgtype(DingMsgTypeEnum.TEXT.getType());
        msg.setText(new OapiChatSendRequest.Text());
        msg.getText().setContent(context);
        request.setMsg(msg);

    }

    /**
     * 发送markdown工作通知
     * @param request
     * @param context
     */
    public void sendMarkdown(OapiMessageCorpconversationAsyncsendV2Request request, String context){
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setMsgtype(DingMsgTypeEnum.MARKDOWN.getType());
        OapiMessageCorpconversationAsyncsendV2Request.Markdown markdown = new OapiMessageCorpconversationAsyncsendV2Request.Markdown();
        markdown.setTitle("带图片的markdown");
        markdown.setText(context);
        msg.setMarkdown(markdown);
        request.setMsg(msg);
    }

    /**
     * 发送普通文本消息
     * @param request
     * @param content
     */
    public void sendText(OapiMessageSendToConversationRequest request, String content) {
        OapiMessageSendToConversationRequest.Text text = new OapiMessageSendToConversationRequest.Text();
        text.setContent(content);
        request.setMsgtype(DingMsgTypeEnum.TEXT.getType());
        request.setText(text);
    }
}

