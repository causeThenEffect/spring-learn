package com.szp.web.plus.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.validation.annotation.Validated;

/**
 * @Description: 排序规则对象
 * @Author: songzhipeng
 */
@Data
@Validated
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("排序规则对象")
public class SortRuleReqVO {

	@ApiModelProperty(value = "排序字段名。根据具体请求而定")
	private String sortName;

	@ApiModelProperty(value = "排序规则。1 升序 2 降序 默认升序")
	@Min(value = 1, message = "排序规则只能是升序(1)或者降序(2)")
	@Max(value = 2, message = "排序规则只能是升序(1)或者降序(2)")
	private Integer rule;

	@ApiModelProperty(value = "优先级。多个字段排序情况下数字越小越优先，最小为0。默认按照位置字段名位置排序")
	@Min(value = 0, message = "优先级最小值为0")
	@Max(value = Integer.MAX_VALUE, message = "优先级最大值为Integer.MAX_VALUE")
	private Integer priority;
}
