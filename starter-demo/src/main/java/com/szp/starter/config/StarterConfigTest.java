package com.szp.starter.config;

import com.szp.starter.service.UserService;
import com.szp.starter.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author cause
 * @DATE 2021/10/20
 */
@Configuration
public class StarterConfigTest {

  @Bean
  public UserService getUserService() {
    return new UserServiceImpl();
  }

  /*@Bean
  public UserService getUserServiceB() {
    return new UserServiceImpl();
  }*/

}
