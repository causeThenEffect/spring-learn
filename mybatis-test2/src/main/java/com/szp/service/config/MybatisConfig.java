package com.szp.service.config;

import com.szp.service.service.UserDetailService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author songzhipeng
 * @create 2021/10/27
 */
@Configuration
public class MybatisConfig {

  @Bean
  public UserDetailService userDetailService() {
    return new UserDetailService();
  }

  @Bean
  public SqlSession sqlSession() {
    String resource = "mybaitsConfig.xml";
    // 加载mybatis的配置文件（它也加载关联的映射文件）
    Reader reader = null;
    try {
      reader = Resources.getResourceAsReader(resource);
    } catch (IOException e) {
      e.printStackTrace();
    }
    // 构建sqlSession的工厂
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    // 创建能执行映射文件中sql的sqlSession，默认是手动提交事务的，使用自动提交的话加上参数 true
    return sqlSessionFactory.openSession(true);
  }

}
