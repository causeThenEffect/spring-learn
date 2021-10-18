package com.szp.basic.web.validate;

/**
 * @Author: songzhipeng
 * @Description:
 */
public interface EnumValidate<T> {

	/**
	 * 校验枚举值是否存在
	 */
	boolean existValidate(T value);
	
}
