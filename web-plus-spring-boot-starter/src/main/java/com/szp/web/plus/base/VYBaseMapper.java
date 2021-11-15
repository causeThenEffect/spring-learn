package com.szp.web.plus.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author cause
 * @version 1.0.0 create time 7/5/2020 5:13 PM
 */
public interface VYBaseMapper<T> extends BaseMapper<T> {


  /**
   * 以下定义的 4个 method 其中 3 个是内置的选装件
   */
  int insertBatchSomeColumn(List<T> entityList);

  int alwaysUpdateSomeColumnById(@Param(Constants.ENTITY) T entity);

  // 逻辑删除
  int deleteByIdWithFill(T entity);

  // 物理删除
  int physicalDeleteById(Serializable id);
}
