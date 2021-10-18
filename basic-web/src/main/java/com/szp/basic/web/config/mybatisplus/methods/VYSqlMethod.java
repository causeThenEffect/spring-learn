package com.szp.basic.web.config.mybatisplus.methods;

public enum VYSqlMethod implements InjectorSqlMethod{

  PHYSICAL_DELETE_BY_ID("physicalDeleteById", "根据ID 删除一条数据", "<script>\nDELETE FROM %s WHERE %s=#{%s}\n</script>");

  String method;

  String desc;

  String sql;

  VYSqlMethod(String method, String desc, String sql) {
    this.method = method;
    this.desc = desc;
    this.sql = sql;
  }

  @Override
  public String getMethod() {
    return this.method;
  }

  @Override
  public String getDesc() {
    return this.desc;
  }

  @Override
  public String getSql() {
    return this.sql;
  }}
