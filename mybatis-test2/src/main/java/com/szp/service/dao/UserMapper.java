package com.szp.service.dao;

import com.szp.service.model.UserDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * @Author cause
 * @create 2021/10/27
 */
@Mapper
public interface UserMapper {

  List<UserDetail> getUsers();

}
