package com.cause.springlistenerlearn.listener;

import com.cause.springlistenerlearn.event.EmailEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * @author cause
 * @date 2021/11/19
 */
@Slf4j
public class EmailListener implements ApplicationListener<EmailEvent> {
  @Override
  public void onApplicationEvent(EmailEvent event) {
    log.info("event====>" + event.getName() + "......." + event.getContent());
  }
}
