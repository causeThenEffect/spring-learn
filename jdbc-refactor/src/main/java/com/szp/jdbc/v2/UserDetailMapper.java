package com.szp.jdbc.v2;

import java.sql.ResultSet;
import java.util.List;

/**
 * @Author cause
 * @create 2021/10/26
 */
public interface UserDetailMapper<T> {

  List<T> query(ResultSet rs) throws Exception;

}
