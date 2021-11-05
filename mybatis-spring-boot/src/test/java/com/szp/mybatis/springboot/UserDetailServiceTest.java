package com.szp.mybatis.springboot;

import com.szp.mybatis.springboot.model.UserDetail;
import com.szp.mybatis.springboot.service.UserDetailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * UserDetailService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>10月 28, 2021</pre>
 */
@SpringBootTest
public class UserDetailServiceTest {

  @Autowired
  UserDetailService userDetailService;

  /**
   * Method: getUsers()
   */
  @Test
  public void testGetUsers() throws Exception {
    userDetailService.getUsers(10, 10);
  }

  @Test
  public void addUsers() {
    Long mobile = 16628561353L;
    String nickname = "test";

    for (int i = 0; i < 10000; i++) {
      UserDetail userDetail = new UserDetail();
      userDetail.setMobile(mobile + i);
      userDetail.setNickname(nickname + i);
      userDetailService.addUsers(userDetail);
    }
  }


} 
