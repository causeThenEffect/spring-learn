package com.cause.mybatis.springboot;

import com.cause.mybatis.springboot.dao.UserMapper;
import com.cause.mybatis.springboot.model.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@Slf4j
public class MybatisCursorTest {

  @Autowired
  SqlSessionFactory sqlSessionFactory;

  @Autowired
  UserMapper userMapper;

  @Test
  public void getFakeCursorTest() {
    Cursor<UserDetail> cursor = userMapper.getFakeCursor();
    for (UserDetail userDetail : cursor) {
      log.info(userDetail.toString());
    }
  }

  @Test
  public void getRealCursorTest() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      Cursor<UserDetail> cursor = mapper.getRealCursor();

      assertFalse(cursor.isOpen());

      // 此处是java针对游标迭代的一个语法糖简化，通过class文件可以看到编译之后的真实代码
      for (UserDetail userDetail : cursor) {
        log.info(userDetail.toString());
      }

    }
  }

}
