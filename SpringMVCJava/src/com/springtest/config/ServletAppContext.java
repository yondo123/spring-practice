package com.springtest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Spring MVC Project 설정
@Configuration
//annotation-driven
@EnableWebMvc
//component-scan
@ComponentScan("com.springtest.controller")
public class ServletAppContext implements WebMvcConfigurer {
	// Controller 반환 view
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		//prifix-path, suffix-path
		registry.jsp("/WEB-INF/views/",".jsp");
	}
}
