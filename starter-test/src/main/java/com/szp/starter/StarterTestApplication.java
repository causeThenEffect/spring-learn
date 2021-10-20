package com.szp.starter;

import com.szp.starter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarterTestApplication implements CommandLineRunner {

  @Autowired
  UserService userService;

  public static void main(String[] args) {
    SpringApplication.run(StarterTestApplication.class, args);
  }


  @Override
  public void run(String... args) throws Exception {
    System.out.println(userService.getUserName());
  }
}
