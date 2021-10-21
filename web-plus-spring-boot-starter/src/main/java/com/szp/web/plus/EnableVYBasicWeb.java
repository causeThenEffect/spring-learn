package com.szp.web.plus;

import com.szp.web.plus.config.WebMvcConfiguration;
import com.szp.web.plus.utils.SpringContextUtil;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;

/**
 * @Author: Edward
 * @Date: 2020/6/29 15:44
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
