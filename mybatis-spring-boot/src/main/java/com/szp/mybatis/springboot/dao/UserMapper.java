package com.szp.mybatis.springboot.dao;

import com.szp.mybatis.springboot.model.UserDetail;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.session.ResultHandler;

/**
 * @Author songzhipeng
 * @create 2021/10/27
 */
@Mapper
public interface UserMapper {

  List<UserDetail> getUsers();


  void addUser(UserDetail userDetail);

  int addUserBatch(List<UserDetail> userDetailList);

  /**
   *
   * 通过这种方式并没有达到获取游标的目的：避免百万级的数据一次全部加载到jvm
   *
   * 这种方式获取的游标其实数据已经被全部加载到内存了，只是没有映射成java对象
   *
   * @return
   */
  Cursor<UserDetail> getFakeCursor();

  /**
   *
   * 实现了mysql数据的流式读取
   *
   * fetchSize = Integer.MIN_VALUE 必须这样设置才可以获取到真正的游标
   *
   * @return
   */
  @Select("select * from user_detail")
  @Options(resultSetType = ResultSetType.FORWARD_ONLY, fetchSize = Integer.MIN_VALUE)
  @ResultType(UserDetail.class)
  Cursor<UserDetail> getRealCursor();

  @Select("select * from user_detail")
  @Options(resultSetType = ResultSetType.FORWARD_ONLY, fetchSize = Integer.MIN_VALUE)
  @ResultType(UserDetail.class)
  void getUsersStream(ResultHandler<UserDetail> resultHandler);

}
