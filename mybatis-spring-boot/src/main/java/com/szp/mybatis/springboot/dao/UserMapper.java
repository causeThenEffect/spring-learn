package com.szp.mybatis.springboot.dao;

import com.szp.mybatis.springboot.model.UserDetail;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author songzhipeng
 * @create 2021/10/27
 */
@Mapper
public interface UserMapper {

  List<UserDetail> getUsers();

}
