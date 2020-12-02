package com.xi.notification.web;

import com.taobao.api.ApiException;
import com.xi.notification.enums.DingMsgTypeEnum;
import com.xi.notification.service.impl.NotifyMessageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>钉钉消息通知controller
 * 优化点：提取字段封装成消息对象
 *
 * @Author xihuimin
 * @Date 2020/12/1
 */
@RestController
@RequestMapping("/message")
public class NotifyMessageController {

    @Autowired
    private NotifyMessageImpl notifyMessage;

    /**
     * 发送工作通知
     * @param userId 指定用户；为null时，给企业所有用户发送通知
     * @param type  消息类型
     * @param content   消息内容
     * @throws ApiException
     */
    @GetMapping("/job")
    public void sendJobMessage(String userId, DingMsgTypeEnum type, String content)
            throws ApiException {
        notifyMessage.sendJobMessage(userId, type, content);
    }

    /**
     * 发送群消息
     * @param chatId
     * @param type
     * @param content
     * @throws ApiException
     */
    @GetMapping("/group")
    public void sendGroupMessage(String chatId, DingMsgTypeEnum type, String content)
            throws ApiException {
        notifyMessage.sendGroupMessage(chatId, type, content);
    }

    /**
     * 发送普通消息
     * @param cid 群会话或者个人会话的id(一个Id只能使用一次)，调用前端api获取cid
     * @param sender 消息发送者userId
     * @param type 消息类型
     * @param content 消息内容
     */
    @GetMapping("/ordinary")
    public void sendOrdinaryMessage(String cid, String sender, DingMsgTypeEnum type, String content)
            throws ApiException {
        notifyMessage.sendOrdinaryMessage(cid, sender, type, content);
    }
}
