package com.szp.logback;

import com.szp.logback.service.UserDetailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDetailServiceTest {

  @Autowired
  UserDetailService userDetailService;

  /**
   * Method: getUsers()
   */
  @Test
  public void testGetUsers() throws Exception {
    userDetailService.getUsers();
  }

} 
