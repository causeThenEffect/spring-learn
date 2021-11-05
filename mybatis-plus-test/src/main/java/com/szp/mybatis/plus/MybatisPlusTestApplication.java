package com.szp.mybatis.plus;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author songzhipeng
 */
@SpringBootApplication
@MapperScan(basePackages = "com.szp.mybatis.plus.*")
public class MybatisPlusTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(MybatisPlusTestApplication.class, args);
  }

}
