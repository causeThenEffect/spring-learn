package com.szp.service.service;

import com.szp.service.model.UserDetail;
import java.util.List;
import java.util.Optional;
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
    List<UserDetail> userDetailList = sqlSession.selectList("com.szp.service.dao.UserMapper.getUsers");
    userDetailList.stream()
        .forEach(userDetail -> Optional.ofNullable(userDetail)
            .ifPresent(userDetail1 -> System.out.println(userDetail.toString())));
  }

}
