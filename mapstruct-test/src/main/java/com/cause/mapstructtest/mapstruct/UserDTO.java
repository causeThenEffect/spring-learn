package com.cause.mapstructtest.mapstruct;

import lombok.Builder;
import lombok.Data;

/**
 * @author cause
 * @date 2022/3/24
 */
@Data
public class UserDTO {
  private String name;
  private String age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }
}
