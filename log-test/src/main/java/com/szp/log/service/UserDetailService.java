package com.szp.log.service;

import com.szp.log.dao.UserMapper;
import com.szp.log.model.UserDetail;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

  private static Log log = LogFactory.getLog(UserDetailService.class);

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
