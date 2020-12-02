package com.xi.notification.service.impl;

import com.xi.notification.model.User;
import com.xi.notification.service.Producer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2020/12/2
 */
@Service
public class ProducerImpl implements Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMsg(String queue, String msg) {
        rabbitTemplate.convertAndSend(queue, msg);
    }

    @Override
    public void sendUser(String queue, User user) {
        rabbitTemplate.convertAndSend(queue, user);
    }

    @Override
    public void sendMsgByFanout(String exchange, String msg) {
        rabbitTemplate.convertAndSend(exchange, "", msg);
    }

    @Override
    public void sendMsgByDirectOrTopic(String exchange, String routingKey, String msg) {
        rabbitTemplate.convertAndSend(exchange, routingKey, msg + " routingKey: " + routingKey);
    }
}
