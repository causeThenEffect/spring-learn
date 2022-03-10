package com.cause.rabbit.consumer.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Receiver3 {

    @RabbitListener(queues = "queue3")
    public void process(String msg, Channel channel, Message message) throws IOException {
        System.out.println("Receiver3 : " + message.toString());
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
