package com.szp.rabbitmqtest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitReturnCallback implements RabbitTemplate.ReturnsCallback {

    Logger log= LoggerFactory.getLogger(RabbitReturnCallback.class);

    @Override
    public void returnedMessage(ReturnedMessage returned) {
        log.info("returnedMessage=====>" + returned.toString());
    }
}
