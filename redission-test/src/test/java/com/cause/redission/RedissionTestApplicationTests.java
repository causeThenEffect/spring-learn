package com.cause.redission;

import com.cause.redission.service.RedisTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedissionTestApplicationTests {

    @Autowired
    RedisTest redisTest;

    @Test
    void contextLoads() {
        redisTest.test1();
    }

    @Test
    void test2() {
        redisTest.test2();
    }

    @Test
    void test3() {
        redisTest.test3();
    }

    @Test
    void test4() {
        redisTest.test4();
    }

    @Test
    void test5() {
        redisTest.test5();
    }

}
