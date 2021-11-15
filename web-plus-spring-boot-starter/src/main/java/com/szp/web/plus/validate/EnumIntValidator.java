package com.szp.web.plus.validate;

import com.google.common.collect.Lists;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.collections4.CollectionUtils;


/**
 * @Author: cause
 * @Description:
 */
public class EnumIntValidator implements ConstraintValidator<EnumIntValid, Integer> {


	private Class<? extends Enum> enumClass;

	@Override
	public void initialize(EnumIntValid constraintAnnotation) {
		enumClass = constraintAnnotation.enumClass();
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
		EnumValidate[] enums = (EnumValidate[]) enumClass.getEnumConstants();
		if (enums == null || enums.length == 0) {
			return false;
		}
		Set<EnumValidate> collect = Lists.newArrayList(enums).stream()
				.filter(enumValidate -> enumValidate.existValidate(value)).collect(
						Collectors.toSet());
		return CollectionUtils.isNotEmpty(collect);
	}
}
