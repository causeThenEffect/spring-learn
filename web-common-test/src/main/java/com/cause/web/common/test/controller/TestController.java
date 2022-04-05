package com.cause.web.common.test.controller;

import com.cause.web.common.exception.ExceptionWrapper;
import com.cause.web.common.exception.Result;
import com.cause.web.common.test.model.User;
import com.cause.web.common.test.redis.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 *
 */
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/test1")
    public Result<Map<String, User>> test1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        return ExceptionWrapper.wrap(()-> testService.test1(list));
    }

    /*@RequestMapping("/test2")
    public String test2() {
        return testService.test1().toString();
    }*/

    @RequestMapping("/test3")
    public Result<User> test3() {
        return ExceptionWrapper.wrap(() -> {
            User user = new User();
            user.setName("name1231");
            user.setAddress("address");
            return user;
        });
    }

    @RequestMapping("/test5")
    public Result<String> test5() {
        return ExceptionWrapper.wrap(()-> testService.test5());
    }

}
