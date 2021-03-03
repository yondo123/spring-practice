package com.springtest.beans;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class DataBean {
	@Length(max = 10, min = 5) // 최소 5글자 ~ 최대 10글자 이내
	private String userId;
	@NotBlank // 빈 값 허용하지 않음
	@Length(max = 20, min = 5) // 최소 5글자 ~ 최대 10글자 이내
	private String userPw;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
}
