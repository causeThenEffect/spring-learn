package com.szp.web.plus.config.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.szp.web.plus.config.mybatisplus.injectoor.MySqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author songzhipeng
 * @version 1.0.0 create time 7/5/2020 5:23 PM
 */
@Configuration
public class MybatisPlusConfig {

  @Bean
  public MySqlInjector sqlInjector() {
    return new MySqlInjector();
  }

  /**
   * 分页插件
   *
   * @return
   */
  @Bean
  public PaginationInterceptor paginationInterceptor() {
    return new PaginationInterceptor();
  }

}
