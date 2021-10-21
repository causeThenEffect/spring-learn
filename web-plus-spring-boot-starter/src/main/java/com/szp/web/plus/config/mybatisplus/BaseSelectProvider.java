package com.szp.web.plus.config.mybatisplus;

import com.szp.web.plus.config.mybatisplus.methods.VYSqlMethod;

public class BaseSelectProvider<T extends VYSqlMethod> {

  private T enums;

  public T getSql(){
    return enums;
  }
}
