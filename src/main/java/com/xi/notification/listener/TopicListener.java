package com.xi.notification.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2020/12/2
 */
@Component
public class TopicListener {

    @RabbitListener(queues = "topicQueue1")
    public void getMessage1(String msg){
        System.out.println("topicQueue1队列监听器监听到消息：" + msg);
    }

    @RabbitListener(queues = "topicQueue2")
    public void getMessage2(String msg){
        System.out.println("topicQueue2队列监听器监听到消息：" + msg);
    }
}
