package com.szp.feignconsumer2.control;

import com.szp.feignconsumer2.dto.SimpleDto;
import com.szp.feignconsumer2.dto.SimpleQry;
import com.szp.feignconsumer2.service.ISimpleClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SimpleCtl {

  private final ISimpleClient feignClient;

  @RequestMapping(value = "/feign-client-call")
  public String simpleClientCall() {
    return feignClient.call();
  }

  @RequestMapping(value = "/feign-client-call/{transparentString}")
  public SimpleDto simpleWithOneParam(@PathVariable("transparentString") String transparentString) {
    return feignClient.simpleWithOneParam(transparentString);
  }

  @RequestMapping(value = "/feign-client-call-with-qry")
  public SimpleDto simpleWithQry() {
    SimpleQry qry = new SimpleQry();
    qry.setRandomNum(123456);
    qry.setTransparentString("transparentString");
    return feignClient.simpleWithQry(qry);
  }
}
