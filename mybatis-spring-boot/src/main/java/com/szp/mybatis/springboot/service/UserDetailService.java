package com.szp.mybatis.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
   * 第二次提交
   * 第三次提交
   * 创建dev分支
   * 第一次提交
   * 第二次提交
   * 第三次提交
   */

  public void getUsers(Integer page, Integer pageSize) {
    PageHelper.startPage(page, pageSize);
    List<UserDetail> userDetailList = userMapper.getUsers();
    PageInfo<UserDetail> pageInfo = new PageInfo<>(userDetailList);
    userDetailList.stream()
        .forEach(userDetail -> Optional.ofNullable(userDetail)
            .ifPresent(userDetail1 -> System.out.println(userDetail.toString())));
  }

  public void addUsers(UserDetail userDetail) {
    userMapper.addUser(userDetail);
  }

}
