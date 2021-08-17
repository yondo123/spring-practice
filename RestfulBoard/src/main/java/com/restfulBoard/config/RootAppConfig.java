package com.restfulBoard.config;

import com.restfulBoard.dto.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class RootAppConfig {
    @Bean("loginUser")
    @SessionScope
    public User user(){
        return new User();
    }
}
