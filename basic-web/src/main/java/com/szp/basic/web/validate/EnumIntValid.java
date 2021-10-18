package com.szp.basic.web.validate;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @Author: songzhipeng
 * @Description:
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Repeatable(EnumIntValid.List.class)
@Constraint(validatedBy = {EnumIntValidator.class})
public @interface EnumIntValid {

	String message() default "{com.vy.commons.validate.EnumValid}";


	// 作用参考@Validated和@Valid的区别
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};


	/**
	 * the enum's class-type
	 *
	 * @return Class
	 */
	Class<?> target() default Class.class;

	/**
	 * 是否忽略空值
	 */
	boolean ignoreEmpty() default false;

	/**
	 * the method's name ,which used to validate the enum's value
	 *
	 * @return method's name
	 */
	String method() default "value";

	/**
	 * 允许的枚举
	 * @return
	 */
	Class<? extends Enum<?>> enumClass();

	/**
	 * Defines several {@link EnumIntValid} annotations on the same element.
	 *
	 * @see EnumIntValid
	 */
	@Documented
	@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
	@Retention(RUNTIME)
	@interface List {
		EnumIntValid[] value();
	}
}
