package com.xi.notification.service;

import com.xi.notification.model.User;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2020/12/2
 */
public interface Producer {

    void sendMsg(String queue, String msg);

    void sendUser(String queue, User user);

    void sendMsgByFanout(String exchange, String msg);

    void sendMsgByDirectOrTopic(String exchange, String routingKey, String msg);
}
