/**
 * 
 */
package com.skillenza.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Mayank
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final String API_DESCRIPTION = "Api Test";

	@Bean
	public Docket sampleApi() {
		return new Docket(DocumentationType.SPRING_WEB).useDefaultResponseMessages(false).groupName("Test REST API's")
				.apiInfo(apiInfo()).select().paths(regex("/.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Advanz 101 Assignment").description(API_DESCRIPTION).version("1.0v").build();
 	}

}
