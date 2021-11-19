package com.szp.mybatis.plus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szp.mybatis.plus.mapper.UserDetailMapper;
import com.szp.mybatis.plus.model.UserDetail;
import com.szp.mybatis.plus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class MybatisPlusTestApplicationTests {

  @Autowired
  UserDetailMapper userDetailMapper;

  @Autowired
  UserService userService;

  @Test
  public void testPage() {
    Page page = new Page<UserDetail>(10, 15);
    Page<UserDetail> userDetailIPage = userDetailMapper.selectPage(page, null);
    Assertions.assertEquals(15, userDetailIPage.getRecords().size());
  }

  /**
   * 测试id是如何生成的
   */
  @Test
  void testaddUserDetail() {

    ArrayList<UserDetail> userDetails = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      UserDetail userDetail = new UserDetail();
      userDetail.setMobile(16628561354L);
//    userDetail.setNickname("wecsdfsdfs");
//      userDetailMapper.insert(userDetail);
      userDetails.add(userDetail);
    }
    userService.saveBatch(userDetails);

//    List<UserDetail> userDetailList = userDetailMapper.selectList(new LambdaQueryWrapper<UserDetail>().eq(UserDetail::getMobile, 16628561354L));
//    userDetailList.forEach(userDetail1 -> log.info(userDetail1.toString()));

  }

  @Test
  void userServiceTest() {
    Long mobile = 17628561353L;
    String nickname = "test";

    int times = 20000;

    for (int i = 1; i <= 500; i++) {
      List<UserDetail> list = new ArrayList<>();
      for (int j = 1; j <= times; j++) {
        UserDetail userDetail = new UserDetail();
        userDetail.setMobile(mobile + j * i);
        userDetail.setNickname(nickname + j * i);
        userDetail.setCreateTime(new Date());
        list.add(userDetail);
      }
      int count = userDetailMapper.addUserBatch(list);
      assertEquals(times, count);
    }
  }


}
