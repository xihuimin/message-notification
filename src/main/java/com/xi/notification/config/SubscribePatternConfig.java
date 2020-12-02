package com.xi.notification.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>发布订阅者模式
 * 包括一个交换机，两个队列(和对应的订阅者)
 * 交换机类型：direct、topic、headers、fanout
 * 这里使用的是fanout交换机，会把消息发送到绑定了该交换机的队列上
 *
 * @Author xihuimin
 * @Date 2020/12/2
 */
@Configuration
public class SubscribePatternConfig {

    @Bean
    public Queue subscribeQueue1(){
        return new Queue("subscribeQueue1");
    }

    @Bean
    public Queue subscribeQueue2(){
        return new Queue("subscribeQueue2");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout");
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(subscribeQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(subscribeQueue2()).to(fanoutExchange());
    }
}
