package com.xi.notification.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>设置两个订阅者分别订阅队列1、队列2
 *
 * @Author xihuimin
 * @Date 2020/12/2
 */
@Component
public class SubscribeListener {

    @RabbitListener(queues = "subscribeQueue1")
    public void getMessage1(String msg){
        //消费消息，执行业务
        System.out.println("subscribeQueue1队列监听器收到消息：" + msg);
    }

    @RabbitListener(queues = "subscribeQueue2")
    public void getMessage2(String msg){
        //消费消息，执行业务
        System.out.println("subscribeQueue2队列监听器收到消息：" + msg);
    }
}
