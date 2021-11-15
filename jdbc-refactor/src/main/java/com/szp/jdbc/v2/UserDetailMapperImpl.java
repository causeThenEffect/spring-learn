package com.szp.jdbc.v2;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author cause
 * @create 2021/10/26
 */
public class UserDetailMapperImpl implements UserDetailMapper<UserDetail>{
  @Override
  public List<UserDetail> query(ResultSet rs) throws Exception {
    List<UserDetail> userDetailList = new ArrayList<>();
    while (rs.next()) {
      UserDetail userDetail = new UserDetail();
      long id = rs.getLong("user_id");
      String name = rs.getString("nickname");
      System.out.println(id + "=======>" + name);
      userDetail.setUserId(id);
      userDetail.setNickname(name);
      userDetailList.add(userDetail);
    }
    return userDetailList;
  }
}
