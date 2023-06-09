package com.pool.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;


@Configuration
@EnableSwagger2
public class DressCoolAppSwaggerConfiguration {
	@Bean
	public Docket DressCoolAppDocket() {
		 return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(getApiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.dress.rest.controller"))
	                .paths(PathSelectors.any())
	                .build();
	}
	
	private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("DRESS COOL APP API")
                .description("This is used to ")
                .version("1.0.0")
                .build();
    }
}
