package com.szp.basic.web.properties;

import com.google.common.collect.Lists;
import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: songzhipeng
 * @Description:
 */
@Data
@Component
@ConfigurationProperties(prefix = "swagger2")
public class SwaggerProperties {

	private ApiInfo api;

	private List<String> baseApiPackages = Lists.newArrayList("com.vy");

	private Integer port;

}
