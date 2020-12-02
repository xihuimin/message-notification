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
public class WorkPatternTest extends AbstractTest {

    @Autowired
    private Producer producer;

    @Test
    public void test(){
        for (int i = 0 ; i < 6 ; i++) {
            producer.sendMsg("workQueue", "工作模式!!!" + i);
        }

    }
}
