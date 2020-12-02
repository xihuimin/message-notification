package com.xi.notification.listener;

import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2020/12/2
 */
@Component
public class RouteListener {

    @RabbitListener(queues = "directQueue1")
    public void getMsg1(String msg){
        System.out.println("directQueue1队列监听器收到消息：" + msg);
    }

    @RabbitListener(queues = "directQueue2")
    public void getMsg2(String msg){
        System.out.println("directQueue2队列监听器收到消息：" + msg);
    }
}
