package com.szp.aspectlearn.annotation;

import com.szp.aspectlearn.enums.SensitiveFilterTypeEnum;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author songzhipeng
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SensitiveListFilter {

	SensitiveFilterTypeEnum filterType() default SensitiveFilterTypeEnum.UNDEFINED;

}
