package com.google.springrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Api(value = "users")
public class SwaggerConfig {

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo());
		
	}
	private ApiInfo apiInfo(){
		Contact contact = new Contact("Ketan Shevale", "https://ketanshevale10.wixsite.com/home", "ketanshevale10@gmail.com");
		ApiInfo api = new ApiInfo("Spring REST API", "REST API", "1.0.1", "TnC", contact, "MIT", "https://opensource.org/licenses/MIT");
		return api;
	}
	
	
}
