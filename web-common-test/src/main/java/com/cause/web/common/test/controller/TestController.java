package com.cause.web.common.test.controller;

import com.cause.web.common.redis.Test;
import com.cause.web.common.test.redis.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class TestController {

  @Autowired
  TestService testService;

  @RequestMapping("/131231")
  public String test() {
    Test test = new Test();

    return test.name;
  }

  @RequestMapping("/test2")
  public String test2() {
    return testService.test1().toString();
  }

}
