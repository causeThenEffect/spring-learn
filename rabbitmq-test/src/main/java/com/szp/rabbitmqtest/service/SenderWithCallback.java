package com.szp.rabbitmqtest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;


//@Component
@Service
public class SenderWithCallback {
    Logger log= LoggerFactory.getLogger(SenderWithCallback.class);
    @Autowired
    private  RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void initRabbitTemplate() {
        // 设置生产者消息确认
        rabbitTemplate.setConfirmCallback(new RabbitConfirmCallback());
        rabbitTemplate.setReturnsCallback(new RabbitReturnCallback());
    }


    public void send() {
        String exchange = "exchange1";

        for (int i = 1; i < 4; i++) {
          String routingKey = "product." + i;
          MessageProperties messageProperties = new MessageProperties();
          String msgId = "unRouting-" + UUID.randomUUID().toString();
          //此处设置的msgId才能被会转成rabbitmq client的messageId，发送给broker
          messageProperties.setMessageId(msgId);
          Message message = new Message(("发送一条消息"+ i).getBytes(), messageProperties);

          rabbitTemplate.convertAndSend(exchange, routingKey, message,
                  new CorrelationData(msgId));
        }
    }

}
