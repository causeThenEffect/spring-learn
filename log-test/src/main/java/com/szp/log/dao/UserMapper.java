package com.szp.log.dao;

import com.szp.log.model.UserDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author songzhipeng
 * @create 2021/10/27
 */
@Mapper
public interface UserMapper {

  List<UserDetail> getUsers();

  void addUser(UserDetail userDetail);

}
