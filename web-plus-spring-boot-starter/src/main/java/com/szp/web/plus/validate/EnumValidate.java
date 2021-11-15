package com.szp.web.plus.validate;

/**
 * @Author: cause
 * @Description:
 */
public interface EnumValidate<T> {

	/**
	 * 校验枚举值是否存在
	 */
	boolean existValidate(T value);
	
}
