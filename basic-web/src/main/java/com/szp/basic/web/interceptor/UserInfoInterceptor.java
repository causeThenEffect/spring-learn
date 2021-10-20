package com.szp.basic.web.interceptor;

import com.google.common.collect.Lists;
import com.szp.basic.web.handler.BaseContextHandler;
import com.szp.basic.web.handler.JwtInfoHeaderKey;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author songzhipeng
 */
public class UserInfoInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    String userId = request.getHeader(JwtInfoHeaderKey.USER_ID_KEY);

    String userRoleCode = request.getHeader(JwtInfoHeaderKey.USER_ROLE_CODE);

    if (StringUtils.isNotBlank(userRoleCode)) {
      String[] roleCodes = StringUtils.split(userRoleCode, ",");
      if (roleCodes != null && roleCodes.length != 0) {
        BaseContextHandler.setRoleCodes(Lists.newArrayList(roleCodes));
      }
    }
    if (StringUtils.isBlank(userId)) {
      BaseContextHandler.setCurrentUserId(BaseContextHandler.DEFAULT_USER_ID);
    } else {
      BaseContextHandler.setCurrentUserId(userId);
    }
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    BaseContextHandler.remove();
    if (Objects.nonNull(ex)) {
      throw ex;
    }
  }
}