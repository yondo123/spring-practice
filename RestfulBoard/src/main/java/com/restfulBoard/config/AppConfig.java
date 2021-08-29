package com.restfulBoard.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    //root-context
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootAppConfig.class, WebSecurityConfig.class};
    }
    //servlet-context
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletAppConfig.class};
    }

    //DispatcherServlet
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //filter 설정
    @Override
    protected Filter[] getServletFilters(){
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        return new Filter[] {encodingFilter};
    }
}
