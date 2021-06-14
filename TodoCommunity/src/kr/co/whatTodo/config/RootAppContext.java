package kr.co.whatTodo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.whatTodo.beans.UserInfoBean;

@Configuration
public class RootAppContext {
	@Bean("loginUserInfoBean")
	@SessionScope
	public UserInfoBean loginUserInfoBean() {
		return new UserInfoBean();
	}
}
