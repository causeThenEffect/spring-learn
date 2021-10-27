package com.szp.service.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author songzhipeng
 * @create 2021/10/27
 */
@Service
public class UserDetailService {

  @Autowired
  private SqlSession sqlSession;

  public void getUsers() {
    sqlSession.selectList("com.szp.learn.dao.getUsers");
  }

}
