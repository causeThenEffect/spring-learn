package com.szp.log;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogTestApplicationTests {

  @Autowired
  private SqlSessionFactory sqlSessionFactory;

  @Test
  void contextLoads() {

  }

}
