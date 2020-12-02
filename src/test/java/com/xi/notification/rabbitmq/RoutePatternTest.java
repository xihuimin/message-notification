package com.xi.notification.rabbitmq;

import com.xi.notification.AbstractTest;
import com.xi.notification.service.Producer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2020/12/2
 */
public class RoutePatternTest extends AbstractTest {

    @Autowired
    private Producer producer;

    @Test
    public void test(){
        producer.sendMsgByDirectOrTopic("direct", "One", "路由模式!!!");
        producer.sendMsgByDirectOrTopic("direct", "Two", "路由模式!!!");
        producer.sendMsgByDirectOrTopic("direct", "Three", "路由模式!!!");
    }
}
