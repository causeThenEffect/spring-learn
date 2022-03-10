package com.cause.rabbit.consumer.service;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Receiver {

    @RabbitListener(queues = "queue1")
    public void process(String msg, Channel channel, Message message) throws IOException, InterruptedException {
        System.out.println("Receiver1 : " + message.toString());

//        int i = 10 /0;
//        Thread.sleep(5000);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            System.out.println("消息消费异常");
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        }
    }
}
