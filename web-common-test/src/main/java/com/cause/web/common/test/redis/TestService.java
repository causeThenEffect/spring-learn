package com.cause.web.common.test.redis;

import com.cause.web.common.redis.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
@Slf4j
public class TestService {


  @RedisCache(name = "testRediscache")
  public Object test1() {
    User user = new User();
    user.setName("name112312");
    user.setAdress("sfsdfsdf");
    log.error("没有命中缓存");
    return user;
  }

}
