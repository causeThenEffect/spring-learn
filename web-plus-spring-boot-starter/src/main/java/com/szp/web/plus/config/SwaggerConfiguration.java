package com.szp.web.plus.config;

import com.szp.web.plus.properties.SwaggerProperties;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;

/**
 * @Author: cause
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
