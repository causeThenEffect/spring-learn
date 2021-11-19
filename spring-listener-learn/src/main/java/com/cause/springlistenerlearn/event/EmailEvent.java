package com.cause.springlistenerlearn.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @author cause
 * @date 2021/11/19
 */
@Data
public class EmailEvent extends ApplicationEvent {

  private String name;

  private String content;

  public EmailEvent(Object source) {
    super(source);
  }

  public EmailEvent(Object source, String name, String content) {
    super(source);
    this.name = name;
    this.content = content;
  }
}
