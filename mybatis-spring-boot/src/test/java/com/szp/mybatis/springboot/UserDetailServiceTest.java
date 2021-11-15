package com.szp.mybatis.springboot;

import com.szp.mybatis.springboot.dao.UserMapper;
import com.szp.mybatis.springboot.model.UserDetail;
import com.szp.mybatis.springboot.service.UserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cursor.Cursor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * UserDetailService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>10月 28, 2021</pre>
 */
@SpringBootTest
@Slf4j
public class UserDetailServiceTest {

  @Autowired
  UserDetailService userDetailService;

  @Autowired
  UserMapper userMapper;

  /**
   * Method: getUsers()
   */
  @Test
  public void testGetUsers() throws Exception {
    userDetailService.getUsers(100000, 10);
  }

  @Test
  public void addUsers() {
    Long mobile = 17628561353L;
    String nickname = "test";

    for (int i = 0; i < 10; i++) {
      UserDetail userDetail = new UserDetail();
      userDetail.setMobile(mobile + i);
      userDetail.setNickname(nickname + i);
      userDetailService.addUsers(userDetail);
    }
  }

  @Test
  public void addUserBatch() {
    Long mobile = 17628561353L;
    String nickname = "test";

    int times = 20000;

    for (int i = 1; i <= 500; i++) {
      List<UserDetail> list = new ArrayList<>();
      for (int j = 1; j <= times; j++) {
        UserDetail userDetail = new UserDetail();
        userDetail.setMobile(mobile + j * i);
        userDetail.setNickname(nickname + j * i);
        list.add(userDetail);
      }
      int count = userDetailService.addUserBatch(list);
      assertEquals(times, count);
    }
  }

} 
