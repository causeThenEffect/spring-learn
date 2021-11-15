package com.szp.pagetest;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.Collections;

/**
 * @Author cause
 * @DATE 2021/10/18
 */
public class FastAutoGeneratorTest {

  public static void main(String[] args) {
    FastAutoGenerator.create("jdbc:mysql://rm-2ze24207w07l455998o.mysql.rds.aliyuncs.com/yzc_sit",
        "visva",
        "WmaiVisva2018")
        .globalConfig(builder -> {
          builder.author("cause") // 设置作者
              .enableSwagger() // 开启 swagger 模式
              .fileOverride() // 覆盖已生成文件
              .outputDir("/Users/cause/IdeaProjects/opensource/spring-learn/page-test/src/main/java/"); // 指定输出目录
        })
        .packageConfig(builder -> {
          builder.parent("com.szp") // 设置父包名
              .moduleName("pagetest"); // 设置父包模块名
//              .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://")); // 设置mapperXml生成路径
        })
        .strategyConfig(builder -> {
          builder.addInclude("user_detail") // 设置需要生成的表名
              .addTablePrefix("t_", "c_"); // 设置过滤表前缀
        })
//        .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
        .execute();
  }

}
