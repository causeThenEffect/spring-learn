package com.szp.rabbitmqtest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitConfirmCallback implements RabbitTemplate.ConfirmCallback {

    Logger log= LoggerFactory.getLogger(RabbitConfirmCallback.class);
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("MessageConfirm correlationData1111:"+correlationData+",ack:"+ack+",cause:"+cause);
    }
}
