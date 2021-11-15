package com.szp.mybatis.springboot.service;

import com.github.pagehelper.PageHelper;
import com.szp.mybatis.springboot.dao.UserMapper;
import com.szp.mybatis.springboot.model.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @Author songzhipeng
 * @create 2021/10/27
 */
@Service
@Slf4j
public class UserDetailService {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  public SqlSessionFactory sqlSessionFactory;

  public void getUsers(Integer page, Integer pageSize) {
    PageHelper.startPage(page, pageSize);
    List<UserDetail> userDetailList = userMapper.getUsers();
    /*PageInfo<UserDetail> pageInfo = new PageInfo<>(userDetailList);
    userDetailList.stream()
        .forEach(userDetail -> Optional.ofNullable(userDetail)
            .ifPresent(userDetail1 -> System.out.println(userDetail.toString())));*/
  }

  public void addUsers(UserDetail userDetail) {
    userMapper.addUser(userDetail);
  }

  public int addUserBatch(List<UserDetail> userDetailList) {
    return userMapper.addUserBatch(userDetailList);
  }


  public void getUsersStream() {
    userMapper.getUsersStream(resultContext -> {
      UserDetail userDetail = resultContext.getResultObject();
      log.info("getUsersStream======>" + userDetail.toString());
    });
  }

}
