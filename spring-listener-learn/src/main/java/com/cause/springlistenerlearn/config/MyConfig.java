package com.cause.springlistenerlearn.config;

import com.cause.springlistenerlearn.listener.EmailListener;
import com.cause.springlistenerlearn.listener.MyListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cause
 * @date 2021/11/19
 */
@Configuration
public class MyConfig {

  @Bean
  public MyListener myListener() {
    return new MyListener();
  }

  @Bean
  public EmailListener emailListener() {
    return new EmailListener();
  }

}
