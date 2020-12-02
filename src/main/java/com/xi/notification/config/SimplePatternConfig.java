package com.xi.notification.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * <p>简单模式配置：一个队列，一个生产者，一个消费者
 * 也算是一种工作模式
 * @Author xihuimin
 * @Date 2020/12/2
 */
@Configuration
public class SimplePatternConfig {

    @Bean
    public Queue simpleQueue(){
        Queue queue = new Queue("simpleQueue");
        return queue;
    }
}
