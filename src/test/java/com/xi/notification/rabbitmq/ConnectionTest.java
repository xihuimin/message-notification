package com.xi.notification.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.xi.notification.AbstractTest;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2020/12/2
 */
public class ConnectionTest extends AbstractTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void connectionTest() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("116.62.22.82");
        factory.setUsername("xhm");
        factory.setPassword("123456");
        factory.setPort(5672);
        Connection connection = null;
        try {
            connection = factory.newConnection();
            System.out.println(connection.getAddress().getHostAddress());
        }finally {
            connection.close();
        }
    }

    @Test
    public void rabbitTemplateTest(){
        Boolean exchange = rabbitTemplate.isRunning();
        System.out.println(exchange);
    }
}
