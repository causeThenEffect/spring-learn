package com.szp.aspectlearn.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

public enum SensitiveFilterTypeEnum {

  UNDEFINED(-1, "未定义枚举值"),
  COMMENT_LIST(1, "评论敏感信息过滤"),
  PULL_LIST(2, "瀑布流信息过滤"),
  FRIEND_LIST(3, "好友列表敏感信息过滤");
  int value;

  String desc;

  SensitiveFilterTypeEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  @JsonValue
  public int getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }

  public static SensitiveFilterTypeEnum getByCode(int code) {
    for (SensitiveFilterTypeEnum item : SensitiveFilterTypeEnum.values()) {
      if (Objects.equals(item.getValue(), code)) {
        return item;
      }
    }
    return UNDEFINED;
  }
}
