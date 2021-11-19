package com.cause.springlistenerlearn;

import com.cause.springlistenerlearn.event.EmailEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class SpringListenerLearnApplicationTests {

  @Autowired
  private WebApplicationContext webapplicationcontext;

  @Test
  void contextLoads() {
    webapplicationcontext.publishEvent(new EmailEvent("object", "172572575@qq.com", "listener"));
  }

}
