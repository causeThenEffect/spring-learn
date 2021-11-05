package com.szp.mybatis.plus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szp.mybatis.plus.mapper.UserDetailMapper;
import com.szp.mybatis.plus.model.UserDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusTestApplicationTests {

  @Autowired
  UserDetailMapper userDetailMapper;

  @Test
  public void testPage() {
    Page page = new Page<UserDetail>(10, 15);
    Page<UserDetail> userDetailIPage = userDetailMapper.selectPage(page, null);
    System.out.println(userDetailIPage.getRecords().toString());
  }

}
