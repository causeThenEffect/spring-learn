package com.szp.logback.service;

import com.szp.logback.dao.UserMapper;
import com.szp.logback.model.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author cause
 * @create 2021/10/27
 */
@Service
@Slf4j
public class UserDetailService {

  /**
   * 在代码中有两种获取log实例的方法
   *
   * 1.通过依赖lombok包，使用@Slf4j注解，直接使用log实例
   *
   * 2.LoggerFactory.getLogger(Class<?> clazz); 获取实例
   *
   */

//  private static Logger logger = LoggerFactory.getLogger(UserDetailService.class);

  @Autowired
  private UserMapper userMapper;

  public void getUsers() {
    List<UserDetail> userDetailList = userMapper.getUsers();
    userDetailList.stream()
            .forEach(userDetail -> Optional.ofNullable(userDetail)
                    .ifPresent(userDetail1 -> log.info(userDetail1.toString())));
  }

  public void addUsers(UserDetail userDetail) {
    userMapper.addUser(userDetail);
  }

}
