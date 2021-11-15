package com.szp.web.plus.base;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.validation.annotation.Validated;

/**
 * @Author: cause
 * @Description:
 */
@Data
@Validated
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BasePageReqVO {

	@Min(1)
	@Max(Integer.MAX_VALUE)
	@NotNull
	@ApiModelProperty(value = "第几页", example = "1")
	protected Integer startPage = 1;

	@Min(10)
	@Max(500)
	@NotNull
	@ApiModelProperty(value = "页面数量", example = "20")
	protected Integer pageSize = 20;

}
