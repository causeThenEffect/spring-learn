package com.szp.web.plus;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.szp.web.plus.config.SwaggerConfiguration;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: Edward
 * @Date: 2020/7/1 20:17
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
