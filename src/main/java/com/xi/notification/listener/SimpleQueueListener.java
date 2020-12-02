package com.xi.notification.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2020/12/2
 */
@Slf4j
@Component
public class SimpleQueueListener {

//    @RabbitListener(queues = "simpleQueue")
//    public void getMessage1(User msg){
//
//        System.out.println("simpleQueue队列监听器监听到消息：" + msg);
//        System.out.println("用户信息：" + msg.toString());
//    }

    @RabbitListener(queues = "simpleQueue")
    public void getMessage2(String msg){
        System.out.println("simpleQueue队列监听器监听到消息：" + msg);
    }
}
