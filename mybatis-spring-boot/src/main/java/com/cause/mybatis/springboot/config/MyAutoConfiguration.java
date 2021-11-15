//package com.szp.mybatis.springboot.config;
//
//import io.github.mybatis.pal.ConsumeTimeInterceptor;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
///**
// * @author cause
// */
//@Configuration
//public class MyAutoConfiguration  implements InitializingBean {
//
//  @Autowired
//  private List<SqlSessionFactory> sqlSessionFactoryList;
//
//  @Override
//  public void afterPropertiesSet() {
//    ConsumeTimeInterceptor interceptor = new ConsumeTimeInterceptor();
//    for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {
//      org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
//      if (!containsInterceptor(configuration, interceptor)) {
//        configuration.addInterceptor(interceptor);
//      }
//    }
//  }
//
//  /**
//   * 是否已经存在相同的拦截器
//   *
//   * @param configuration
//   * @param interceptor
//   * @return
//   */
//  private boolean containsInterceptor(org.apache.ibatis.session.Configuration configuration, Interceptor interceptor) {
//    try {
//      // getInterceptors since 3.2.2
//      return configuration.getInterceptors().contains(interceptor);
//    } catch (Exception e) {
//      return false;
//    }
//  }
//
//}
