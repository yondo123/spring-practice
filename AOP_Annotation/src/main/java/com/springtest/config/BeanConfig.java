package com.springtest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//bean 패키지, 어드바이저 패키지 scan
@ComponentScan(basePackages={"com.springtest.beans, com.springtest.advisor"})
@EnableAspectJAutoProxy
public class BeanConfig {

}
