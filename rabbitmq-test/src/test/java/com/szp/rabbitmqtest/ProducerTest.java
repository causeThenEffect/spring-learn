package com.szp.rabbitmqtest;

import com.rabbitmq.client.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;
import java.util.HashMap;
import java.util.UUID;

public class ProducerTest {
  public static void main(String[] args) throws IOException, TimeoutException {
    ConnectionFactory factory = new ConnectionFactory();
    // 设置接入点，在消息队列RabbitMQ版控制台实例详情页面查看。
    factory.setHost("amqp-cn-7mz2liifa00a.mq-amqp.cn-hangzhou-249959-a.aliyuncs.com");
    // ${instanceId}为实例ID，在消息队列RabbitMQ版控制台实例详情页面查看。
    // ${AccessKey}阿里云身份验证，在阿里云控制台创建。
    // ${SecretKey}阿里云身份验证，在阿里云控制台创建。
    factory.setCredentialsProvider(new AliyunCredentialsProvider("LTAI5tLRrEm2PdRywtVvot77", "zEvOyDfnmRq6nAXHddgaYJkLiRRWgf","amqp-cn-7mz2liifa00a"));
    //设置为true，开启Connection自动恢复功能；设置为false，关闭Connection自动恢复功能。
    factory.setAutomaticRecoveryEnabled(true);
    factory.setNetworkRecoveryInterval(5000);
    // 设置Vhost名称，请确保已在消息队列RabbitMQ版控制台上创建完成。
    factory.setVirtualHost("test1111");
    // 默认端口，非加密端口5672，加密端口5671。
    factory.setPort(5672);
    // 基于网络环境合理设置超时时间。
    factory.setConnectionTimeout(30 * 1000);
    factory.setHandshakeTimeout(30 * 1000);
    factory.setShutdownTimeout(0);
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();
    channel.exchangeDeclare("e111", "direct", true, false, false, null);
    channel.queueDeclare("q111", true, false, false, new HashMap<String, Object>());
    channel.queueBind("q111", "e111", "33333");
    // 开始发送消息。
    for (int i = 0; i < 100; i++  ) {
      // ${ExchangeName}必须在消息队列RabbitMQ版控制台上已存在，并且Exchange的类型与控制台上的类型一致。
      // ${BindingKey}根据业务需求填入相应的BindingKey。
      AMQP.BasicProperties props = new AMQP.BasicProperties.Builder().messageId(UUID.randomUUID().toString()).build();
      channel.basicPublish("e111", "33333", true, props,
              ("消息发送Body"  + i).getBytes(StandardCharsets.UTF_8));
    }
    connection.close();
  }
}
