package com.szp.feignconsumer2.service;

import com.szp.feignconsumer2.dto.SimpleDto;
import com.szp.feignconsumer2.dto.SimpleQry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 通过feign访问服务, name:指定服务的名称 fallback：指定断路器
 * <p>
 * feign默认已经使用ribbion做为负载均衡： FeignRibbonClientAutoConfiguration
 *
 * @author cause
 */
// fallback和fallbackFactory只能有一个，fallback会覆盖fallbackFactory的实现
@FeignClient(value = "config-client2", path = "/", fallback = FeignClientFallback.class)
//@FeignClient(name="${feign.servicename}", fallbackFactory=FeignClientFallbackFactory.class)
public interface ISimpleClient {

  @GetMapping("/simple")
  String call();

  @RequestMapping(value = "/simplewithoneparam/{transparentString}")
  SimpleDto simpleWithOneParam(@PathVariable("transparentString") String transparentString);

  // 如果使用fastjson，则需要加上consumes参数
  @RequestMapping(value = "/simplewithqry", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8")
  SimpleDto simpleWithQry(@RequestBody SimpleQry qry);
}
