package com.szp.web.plus;

import com.szp.web.plus.config.mybatisplus.MybatisPlusConfig;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

/**
 * @author Edward_liu
 * @version 1.0.0 create time 7/5/2020 5:24 PM
 */
@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MybatisPlusConfig.class)
public @interface EnableVYBasicMybatisPlus {

}
