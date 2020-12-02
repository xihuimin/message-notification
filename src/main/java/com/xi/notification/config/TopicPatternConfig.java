package com.xi.notification.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>主题模式
 * 一个topic交换机，两个队列
 *
 * #表示0个或若干个关键字，*表示一个关键字
 * @Author xihuimin
 * @Date 2020/12/2
 */
@Configuration
public class TopicPatternConfig {

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topic");
    }

    @Bean
    public Queue topicQueue1(){
        return new Queue("topicQueue1");
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue("topicQueue2");
    }

    @Bean
    public Binding bindingTopic1(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("x.#");
    }

    @Bean
    public Binding bindingTopic2(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("l.#");
    }

    @Bean
    public Binding bindingTopic3(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("#.test.#");
    }
}
