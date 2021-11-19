package com.cause.mybatis.springboot;

import com.cause.mybatis.springboot.dao.UserMapper;
import com.cause.mybatis.springboot.model.UserDetail;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author cause
 * @date 2021/11/15
 */
@SpringBootTest
@Slf4j
class PageTest {

  @Autowired
  UserMapper userMapper;

  @Test
  void testGetUsers() {
    PageHelper.startPage(100000, 10);
    List<UserDetail> userDetailList = userMapper.getUsers();
    assertEquals(10, userDetailList.size());
  }

}
