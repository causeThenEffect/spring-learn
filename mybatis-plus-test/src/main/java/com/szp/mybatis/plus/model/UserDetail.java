package com.szp.mybatis.plus.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @Author cause
 * @create 2021/10/27
 */
@Data
@TableName(value = "user_detail")
public class UserDetail {

  @TableId(type = IdType.ASSIGN_ID)
  private Long id;

  private Long mobile;

  @TableField(fill = FieldFill.INSERT)
  private String nickname;

  @TableField(fill = FieldFill.INSERT)
  private Date createTime;

}
