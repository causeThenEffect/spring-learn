package com.cause.web.common.test.redis;

import com.cause.web.common.redis.RedisCache;
import com.cause.web.common.test.model.User;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
@Slf4j
public class TestService {

  @Autowired
  RedissonClient redissonClient;

  @RedisCache(name = "test344")
  public Map<String, User> test1(List<String> list) {
    Map<String, User> map = new HashMap<>();
    User user = new User();
    user.setName("name112312");
    user.setAddress("sfsdfsdf");
    log.error("没有命中缓存");
    map.put(list.get(0), user);
    return map;
  }

  public String test5() {
    RBucket<Long> bucket = redissonClient.getBucket("test");
    String s = String.valueOf(bucket.get());
    System.out.println(s);
    return s;
  }

}
