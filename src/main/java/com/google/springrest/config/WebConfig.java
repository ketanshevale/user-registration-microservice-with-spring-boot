package com.google.springrest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//to enable web configuration use, it will understand HTTP request, session, etc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
//    @Override
//    public void addCorsMappings(CorsRegistry registry){
//    	registry.addMapping("/api/**")
//    	.allowedOrigins("http://mocker.egen.io")
//    	.allowedMethods("GET", "PUT", "POST", "DELETE", "OPTION", "PATCH");
//    }
}	