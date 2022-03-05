package com.cause.feignproduce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cause
 * @date 2022/2/8
 */
@RestController
public class ProduceController {

  @RequestMapping(value = "/m1")
  public String m1() {
    return "m1.....";
  }

}
