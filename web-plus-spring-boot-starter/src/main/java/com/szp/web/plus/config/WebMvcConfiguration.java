package com.szp.web.plus.config;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.common.collect.Lists;
import com.szp.web.plus.interceptor.UserInfoInterceptor;
import java.util.List;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebMvcConfiguration extends WebMvcAutoConfiguration implements WebMvcConfigurer {

  @Bean
  public UserInfoInterceptor getUserIdInterceptor() {
    return new UserInfoInterceptor();
  }


  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(getUserIdInterceptor())
        .addPathPatterns(interceptALl())
        .excludePathPatterns("/provider/**");
  }

  private List<String> interceptALl() {
    return Lists.newArrayList("/**");
  }

  private List<String> passAll() {
    return Lists.newArrayList("/**");
  }


  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    /*
     * 序列换成json时,将所有的long变成string
     * 因为js中得数字类型不能包含所有的java long值
     */
    SimpleModule simpleModule = new SimpleModule();
    simpleModule.addSerializer(Long.class, new MgToStringSerializer());
    simpleModule.addSerializer(Long.TYPE, new MgToStringSerializer());

    converters.stream().filter(o -> o instanceof MappingJackson2HttpMessageConverter)
        .map(o -> (MappingJackson2HttpMessageConverter) o).forEach(converter -> {
      converter.getObjectMapper().registerModule(simpleModule);
    });
  }
}
