package com.xi.notification.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>模拟两个消费者监听同一个队列
 *
 * @Author xihuimin
 * @Date 2020/12/2
 */
@Component
public class workQueueListener {

    @RabbitListener(queues = "workQueue")
    public void getMessage1(String msg){
        System.out.println("workQueue队列监听器1号监听到消息：" + msg);
    }

    @RabbitListener(queues = "workQueue")
    public void getMessage2(String msg){
        System.out.println("workQueue队列监听器2号监听到消息：" + msg);
    }
}
