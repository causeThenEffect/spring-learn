package com.szp.rabbitmqtest.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cause
 * @date 2022/3/8
 */
@Configuration
public class RabbitConfig {
  //实例Id 从阿里云AMQP控制台获取
  private static final String  INSTANCE_ID="amqp-cn-7mz2liifa00a";
  @Autowired
  private RabbitProperties rabbitProperties;


  @Bean
  public ConnectionFactory getConnectionFactory() {
    com.rabbitmq.client.ConnectionFactory rabbitConnectionFactory =
            new com.rabbitmq.client.ConnectionFactory();
    rabbitConnectionFactory.setHost(rabbitProperties.getHost());
    rabbitConnectionFactory.setPort(rabbitProperties.getPort());
    rabbitConnectionFactory.setVirtualHost(rabbitProperties.getVirtualHost());

    AliyunCredentialsProvider credentialsProvider = new AliyunCredentialsProvider(
            rabbitProperties.getUsername(), rabbitProperties.getPassword(), INSTANCE_ID);
    rabbitConnectionFactory.setCredentialsProvider(credentialsProvider);
    rabbitConnectionFactory.setAutomaticRecoveryEnabled(true);
    rabbitConnectionFactory.setNetworkRecoveryInterval(5000);
    ConnectionFactory connectionFactory = new CachingConnectionFactory(rabbitConnectionFactory);
    ((CachingConnectionFactory)connectionFactory).setPublisherConfirmType(rabbitProperties.getPublisherConfirmType());
    ((CachingConnectionFactory)connectionFactory).setPublisherReturns(rabbitProperties.isPublisherReturns());
    return connectionFactory;
  }

  @Bean
  public Queue queue1() {
    Map<String, Object> arguments = new HashMap<>(4);
    return new Queue("queue1", true, false, false, arguments);
  }

  @Bean
  public Queue queue2() {
    Map<String, Object> arguments = new HashMap<>(4);
    return new Queue("queue2", true, false, false, arguments);
  }

  @Bean
  public Queue queue3() {
    Map<String, Object> arguments = new HashMap<>(4);
    return new Queue("queue3", true, false, false, arguments);
  }

  @Bean
  public Exchange exchange1() {
    Map<String, Object> arguments = new HashMap<>(4);
    return new TopicExchange("exchange1", true, false, arguments);
  }

  @Bean
  public Binding binding1(Queue queue1, Exchange exchange1) {
    return BindingBuilder.bind(queue1).to(exchange1).with("*.1").noargs();
  }

  @Bean
  public Binding binding2(Queue queue2, Exchange exchange1) {
    return BindingBuilder.bind(queue2).to(exchange1).with("*.2").noargs();
  }

  @Bean
  public Binding binding3(Queue queue3, Exchange exchange1) {
    return BindingBuilder.bind(queue3).to(exchange1).with("*.3").noargs();
  }


}
