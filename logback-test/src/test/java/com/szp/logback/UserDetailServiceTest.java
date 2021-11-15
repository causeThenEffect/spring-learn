package com.szp.logback;

import com.szp.logback.dao.UserMapper;
import com.szp.logback.model.UserDetail;
import com.szp.logback.service.UserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Reader;
import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class UserDetailServiceTest {

  @Autowired
  UserDetailService userDetailService;

  @Autowired
  SqlSessionFactory sqlSessionFactory;

  @Before
  public void setBefore() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    Connection connection = sqlSession.getConnection();
    ScriptRunner scriptRunner = new ScriptRunner(connection);
    Reader reader = Resources.getResourceAsReader("create-table.sql");
    scriptRunner.runScript(reader);

    Long mobile = 16628561353L;
    String nickname = "test";

    for (int i = 0; i < 100; i++) {
      UserDetail userDetail = new UserDetail();
      userDetail.setId(i);
      userDetail.setMobile(mobile + i);
      userDetail.setNickname(nickname + i);
      userDetailService.addUsers(userDetail);
    }

  }


  /**
   * Method: getUsers()
   *
   * todo 改成使用内存数据库（hqsldb），方便测试，不用依赖于mysql
   */
  @Test
  public void testGetUsers() throws Exception {
    userDetailService.getUsers();
  }

} 
