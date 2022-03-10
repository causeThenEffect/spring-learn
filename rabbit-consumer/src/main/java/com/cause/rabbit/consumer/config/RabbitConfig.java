package com.cause.rabbit.consumer.config;

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

}
