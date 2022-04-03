package com.cause.mapstructtest.mapstruct;

import lombok.Data;

/**
 * @author cause
 * @date 2022/3/24
 */
@Data
public class User {

  private String id;
  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
