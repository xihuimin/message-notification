package com.xi.notification.web;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitMqController {

    @Autowired
    private RabbitTemplate rabbitTemplate;
}
