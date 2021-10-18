package com.szp.basic.web.config;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.szp.basic.web.properties.SwaggerProperties;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author: songzhipeng
 * @Description:
 */
@AllArgsConstructor
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerConfiguration {

	private final SwaggerProperties swaggerProperties;

	/*@Bean
	public Docket createRestApi() {
		ParameterBuilder authorization = new ParameterBuilder();
		List<Parameter> pars = Lists.newArrayList();
		authorization.name(HttpHeaders.AUTHORIZATION)
				.description("access_token")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(false).build(); // header中的ticket参数非必填，传空也可以 pars.add(ticketPar.build());
		pars.add(authorization.build());
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(Predicates.or(swaggerProperties.getBaseApiPackages().stream()
						.map(RequestHandlerSelectors::basePackage).collect(Collectors.toSet())))
				.paths(PathSelectors.any()).build().globalOperationParameters(pars);
	}*/

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(Optional.ofNullable(swaggerProperties.getApi().getTitle())
						.orElse("上海维外科技有限公司REST API文档"))
				.description(Optional.ofNullable(swaggerProperties.getApi().getDescription())
						.orElse("SWAGGER-UI RESTFUL API"))
				.contact(Optional.ofNullable(swaggerProperties.getApi().getContact())
						.orElse(new Contact("", "", "")))
				.version(Optional.ofNullable(swaggerProperties.getApi().getVersion())
						.orElse(DocumentationType.SWAGGER_2.getVersion()))
				.license(Optional.ofNullable(swaggerProperties.getApi().getLicense()).orElse(""))
				.licenseUrl(Optional.ofNullable(swaggerProperties.getApi().getLicenseUrl()).orElse(""))
				.termsOfServiceUrl(Optional.ofNullable(swaggerProperties.getApi().getTermsOfServiceUrl())
						.orElse("http://localhost:" + swaggerProperties.getPort() + "/"))//TODO
				.build();
	}

}
