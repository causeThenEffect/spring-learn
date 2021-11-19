package com.cause.springlistenerlearn.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author cause
 * @date 2021/11/19
 */
@Slf4j
public class MyListener implements ApplicationListener<ContextRefreshedEvent> {
  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    log.info("getBeanDefinitionCount=====>" + event.getApplicationContext().getBeanDefinitionCount());
    log.info("onApplicationEvent time--------->" + event.getTimestamp());
  }
}
