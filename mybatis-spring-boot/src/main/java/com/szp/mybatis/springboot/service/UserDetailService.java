package com.szp.mybatis.springboot.service;

import com.szp.mybatis.springboot.dao.UserMapper;
import com.szp.mybatis.springboot.model.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author songzhipeng
 * @create 2021/10/27
 */
@Service
public class UserDetailService {

  @Autowired
  private UserMapper userMapper;

  /**
   * 第一次提交
   */

  public void getUsers() {
    List<UserDetail> userDetailList = userMapper.getUsers();
    userDetailList.stream()
        .forEach(userDetail -> Optional.ofNullable(userDetail)
            .ifPresent(userDetail1 -> System.out.println(userDetail.toString())));
  }

}
