package com.szp.aspectlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AspectLearnApplication {

  public static void main(String[] args) {
    SpringApplication.run(AspectLearnApplication.class, args);
  }

}
