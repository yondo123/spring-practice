package com.springtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
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
		// prifix-path, suffix-path
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("/WEB-INF/veiws/requestTest.html");
	}
	
	//properties 파일을 메시지로 등록
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		res.setBasename("/WEB-INF/properties/error_message"); //파일 이름까지만 등록
		return res;
	}
}