package com.cause.redission.service;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RBuckets;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RedisTest {

    @Autowired
    RedissonClient redissonClient;

    public void test5() {
        RBucket<User> bucket = redissonClient.getBucket("eeq" + ":1231");
        User user = new User();
        user.setId(1231);
        user.setName("sefsdfs");
        bucket.set(user, 20, TimeUnit.SECONDS);
        User user1 = bucket.get();
        System.out.println(user1.toString());
    }

    public void test2() {
        RMap<Long, String> rMap = redissonClient.getMap("test2");
        Set<Long> set1 = new HashSet<>(Arrays.asList(1L, 1L, 1L));
//        Map<Long, String> all = rMap.getAll(set1);
        Map<Long, String> all = rMap.getAll(new HashSet<>());
        System.out.println(all.toString());

        rMap.expire(5, TimeUnit.SECONDS);
    }

    public void test3() {
        RMap<Object, Object> rMap = redissonClient.getMap("hhahah");
        boolean isExpire = false;
        if (rMap.size() == 0) {
            isExpire = true;
        }
        HashMap hashMap =new HashMap<>();
        hashMap.put(1L, "1111");
        hashMap.put(2L, "2222");
        hashMap.put(3L, "333");
        rMap.putAll(hashMap);

        if (isExpire) {
            rMap.expire(60, TimeUnit.SECONDS);
        }
    }

    public void test4() {
        RMap<Object, Object> rMap = redissonClient.getMap("hhahah");
        HashMap hashMap =new HashMap<>();
        hashMap.put(4L, "1111");
        hashMap.put(5L, "2222");
        hashMap.put(6L, "333");
        rMap.putAll(hashMap);
    }

    public void test1() {
        RMap<Long, String> test2 = null;
        try {
            test2 = redissonClient.getMap("test2");
            test2.put(1L, "erwer");
            test2.put(2L, "dgsfg");
            test2.put(3L, "rwerw");
            HashSet<Long> set1 = new HashSet<>(Arrays.asList(1L, 2L, 3L));
            Map<Long, String> all = test2.getAll(set1);
            System.out.println(all.toString());

            HashMap hashMap =new HashMap<>();
            hashMap.put(1L, "1111");
            hashMap.put(2L, "2222");
            hashMap.put(3L, "333");
            test2.putAll(hashMap);

            Map<Long, String> all3 = test2.getAll(set1);
            System.out.println(all3.toString());

            HashSet<Long> set = new HashSet<>();
            set.add(4L);
            set.add(5L);
            Map<Long, String> all2 = test2.getAll(set);

            int a = 10 / 0;
        } catch (Throwable e) {
            log.error("sds{}df", 1313, e);
        }

    }

}
