package com.szp.basic.web;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.szp.basic.web.config.SwaggerConfiguration;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: songzhipeng
 * @Description:
 */
@Inherited
@Documented
@EnableKnife4j
@EnableSwagger2
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({SwaggerConfiguration.class})
public @interface EnableVYSwagger2 {

}
