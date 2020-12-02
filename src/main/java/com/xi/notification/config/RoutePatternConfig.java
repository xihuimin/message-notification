package com.xi.notification.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>路由模式
 * 交换机只会将消息发送给匹配到routingKey的队列上
 * 一个direct交换机、两个队列
 *
 * @Author xihuimin
 * @Date 2020/12/2
 */
@Configuration
public class RoutePatternConfig {

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct");
    }

    @Bean
    public Queue directQueue1(){
        return new Queue("directQueue1");
    }

    @Bean
    public Queue directQueue2(){
        return new Queue("directQueue2");
    }

    @Bean
    public Binding bindingOne(){
        return BindingBuilder.bind(directQueue1()).
                to(directExchange()).with("One");
    }

    @Bean
    public Binding bindingTwo(){
        return BindingBuilder.bind(directQueue1()).
                to(directExchange()).with("Two");
    }

    @Bean
    public Binding bindingThree(){
        return BindingBuilder.bind(directQueue2()).
                to(directExchange()).with("Three");
    }
}
