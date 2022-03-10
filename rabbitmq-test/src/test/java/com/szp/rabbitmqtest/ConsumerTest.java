package com.szp.rabbitmqtest;

import com.rabbitmq.client.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

public class ConsumerTest {
  public static void main(String[] args) throws IOException, TimeoutException {
    ConnectionFactory factory = new ConnectionFactory();
    // 设置接入点，在消息队列RabbitMQ版控制台实例详情页面查看。
    factory.setHost("xxx.xxx.aliyuncs.com");
    // ${instanceId}为实例ID，在消息队列RabbitMQ版控制台概览页面查看。
    // ${AccessKey}阿里云身份验证，在阿里云控制台创建。
    // ${SecretKey}阿里云身份验证，在阿里云控制台创建。
    factory.setCredentialsProvider(new AliyunCredentialsProvider("${AccessKeyID}", "${AccessKeySecret}","${SecurityToken}","${instanceId}"));
    //设置为true，开启Connection自动恢复功能；设置为false，关闭Connection自动恢复功能。
    factory.setAutomaticRecoveryEnabled(true);
    factory.setNetworkRecoveryInterval(5000);
    // 设置Vhost名称，请确保已在消息队列RabbitMQ版控制台上创建完成。
    factory.setVirtualHost("${VhostName}");
    // 默认端口，非加密端口5672，加密端口5671。
    factory.setPort(5672);
    factory.setConnectionTimeout(300 * 1000);
    factory.setHandshakeTimeout(300 * 1000);
    factory.setShutdownTimeout(0);
    Connection connection = factory.newConnection();
    final Channel channel = connection.createChannel();
    // 创建${ExchangeName}，该Exchange必须在消息队列RabbitMQ版控制台上已存在，并且Exchange的类型与控制台上的类型一致。
    AMQP.Exchange.DeclareOk exchangeDeclareOk = channel.exchangeDeclare("${ExchangeName}", "${ExchangeType}", true, false, false, null);
    // 创建${QueueName} ，该Queue必须在消息队列RabbitMQ版控制台上已存在。
    AMQP.Queue.DeclareOk queueDeclareOk = channel.queueDeclare("${QueueName}", true, false, false, new HashMap<String, Object>());
    // Queue与Exchange进行绑定，并确认绑定的BindingKeyTest。
    AMQP.Queue.BindOk bindOk = channel.queueBind("${QueueName}", "${ExchangeName}", "BindingKeyTest");
    // 开始消费消息。
    channel.basicConsume("${QueueName}", false, "ConsumerTag", new DefaultConsumer(channel) {
      @Override
      public void handleDelivery(String consumerTag, Envelope envelope,
                                 AMQP.BasicProperties properties, byte[] body)
              throws IOException {
        //接收到的消息，进行业务逻辑处理。
        System.out.println("Received： "  + new String(body, StandardCharsets.UTF_8) +  ", deliveryTag: "  + envelope.getDeliveryTag()  + ", messageId: " +  properties.getMessageId());
        channel.basicAck(envelope.getDeliveryTag(), false);
      }
    });
    connection.close();
  }
}
