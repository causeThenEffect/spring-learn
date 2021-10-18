package com.szp.basic.web;

import com.szp.basic.web.config.WebMvcConfiguration;
import com.szp.basic.web.utils.SpringContextUtil;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;

/**
 * @Author: songzhipeng
 * @Description:
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Import({WebMvcConfiguration.class,
		SpringContextUtil.class})
@ComponentScans(value = {@ComponentScan("com.vy.basic.web.handler")})
public @interface EnableVYBasicWeb {

}
