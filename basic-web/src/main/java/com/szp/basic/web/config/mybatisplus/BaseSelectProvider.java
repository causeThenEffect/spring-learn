package com.szp.basic.web.config.mybatisplus;

import com.szp.basic.web.config.mybatisplus.methods.VYSqlMethod;

public class BaseSelectProvider<T extends VYSqlMethod> {

  private T enums;

  public T getSql(){
    return enums;
  }
}
