package com.cause.mapstructtest;

import com.cause.mapstructtest.mapstruct.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class MapstructTestApplicationTests {

  @Autowired
  UserService userService;

  @Test
  void contextLoads() {
    userService.test1();
  }

}
