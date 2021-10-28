package com.szp.service.service;

import com.szp.service.config.MybatisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* UserDetailService Tester.
*
* @author <Authors name>
* @since <pre>10月 27, 2021</pre>
* @version 1.0
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MybatisConfig.class)
public class UserDetailServiceTest {

  @Autowired
  private UserDetailService userDetailService;

  @Test
  public void testGetUsrs() throws Exception {
    userDetailService.getUsers();
  }

}
