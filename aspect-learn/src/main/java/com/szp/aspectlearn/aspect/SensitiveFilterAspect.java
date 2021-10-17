package com.szp.aspectlearn.aspect;

import com.szp.aspectlearn.annotation.SensitiveListFilter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author songzhipeng
 * @DATE 2021/10/17
 */
@Aspect
@Component
public class SensitiveFilterAspect {

  @Around("@annotation(sensitiveListFilter)")
  public Object sensitiveListFilter(ProceedingJoinPoint joinPoint, SensitiveListFilter sensitiveListFilter)
      throws Throwable {

    Object object = joinPoint.proceed();
    switch (sensitiveListFilter.filterType().getValue()) {
      case 1:
        object = handCommentList(object);
        break;
      case 2:
        object = handPullList(object);
        break;
      case 3:
        object = handFriendList(object);
        break;
    }
    return object;
  }

  private Object handFriendList(Object object) {
    String string = (String) object;
    return "sensitive filter " + string;
  }

  private Object handPullList(Object object) {
    String string = (String) object;
    return "sensitive filter " + string;
  }

  private Object handCommentList(Object object) {
    String string = (String) object;
    return "sensitive filter " + string;
  }

}
