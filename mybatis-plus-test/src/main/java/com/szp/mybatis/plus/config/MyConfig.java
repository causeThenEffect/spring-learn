package com.szp.mybatis.plus.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import io.github.mybatis.pal.ConsumeTimeInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

/**
 * @author cause
 */
@Configuration
public class MyConfig implements InitializingBean {

  @Autowired
  private List<SqlSessionFactory> sqlSessionFactoryList;

  /**
   * 必须配置一下，不然分页功能失效
   *
   * @return
   */
  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
    return interceptor;
  }

  @Override
  public void afterPropertiesSet() {
    for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {
      sqlSessionFactory.getConfiguration().addInterceptor(new ConsumeTimeInterceptor());
    }
  }

  @Bean
  public MetaObjectHandler metaObjectHandler() {
    return new MetaObjectHandler() {
      @Override
      public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "nickname", String.class, "nickname12312312");
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
      }

      @Override
      public void updateFill(MetaObject metaObject) {

      }
    };
  }

  /*@Bean
  public PaginationInnerInterceptor paginationInnerInterceptor() {
    return new PaginationInnerInterceptor();
  }*/

}
