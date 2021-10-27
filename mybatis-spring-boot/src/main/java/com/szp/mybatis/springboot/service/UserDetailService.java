package com.szp.mybatis.springboot.service;

import com.szp.mybatis.springboot.dao.UserMapper;
import com.szp.mybatis.springboot.model.UserDetail;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author songzhipeng
 * @create 2021/10/27
 */
@Service
public class UserDetailService {

  @Autowired
  private UserMapper userMapper;

  public void getUsers() {
    List<UserDetail> userDetailList = userMapper.getUsers();
    userDetailList.stream()
        .forEach(userDetail -> Optional.ofNullable(userDetail)
            .ifPresent(userDetail1 -> System.out.println(userDetail.toString())));
  }

}
