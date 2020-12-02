package com.xi.notification.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>工作模式
 * 包含一个队列，两个及以上消费者(mq循环分发消息：每个消费者获得相同数量的消息)
 *
 * @Author xihuimin
 * @Date 2020/12/2
 */
@Configuration
public class WorkPatternConfig {

    @Bean
    public Queue workQueue(){
        Queue queue = new Queue("workQueue");
        return queue;
    }
}
