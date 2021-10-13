package com.szp.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author songzhipeng
 * @DATE 2021/10/13
 */
@RestController
public class HelloController {

  @GetMapping("/hello")
  @ResponseBody
  String home() {
    return "Hello ,spring security!";
  }

}
