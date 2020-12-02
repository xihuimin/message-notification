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
public class TopicPatternTest extends AbstractTest {

    @Autowired
    private Producer producer;

    @Test
    public void test(){
        producer.sendMsgByDirectOrTopic("topic", "x.ihuiming", "主题模式!!!");
        producer.sendMsgByDirectOrTopic("topic", "l.uoyuting", "主题模式!!!");
        producer.sendMsgByDirectOrTopic("topic", "dandan.test", "主题模式!!!");
    }
}
