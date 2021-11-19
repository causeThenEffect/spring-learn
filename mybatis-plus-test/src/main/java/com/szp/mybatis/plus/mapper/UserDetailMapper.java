package com.szp.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.szp.mybatis.plus.model.UserDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author cause
 */
@Mapper
public interface UserDetailMapper extends BaseMapper<UserDetail> {

  int addUserBatch(List<UserDetail> userDetailList);

}
