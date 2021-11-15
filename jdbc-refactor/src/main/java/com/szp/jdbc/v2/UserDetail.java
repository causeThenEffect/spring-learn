package com.szp.jdbc.v2;

/**
 * @Author cause
 * @create 2021/10/26
 */
public class UserDetail {

  private Long userId;

  private String nickname;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
}
