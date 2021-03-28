package kr.co.whatTodo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.whatTodo.beans.UserInfoBean;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserInfoBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserInfoBean userInfoBean = (UserInfoBean)target;
		if(userInfoBean.getUserPw().equals(userInfoBean.getConfirmPw()) == false) {
			errors.rejectValue("userPw","NotEquals");
			errors.rejectValue("confirmPw","NotEquals");
		}
		
		if(userInfoBean.getisUserCheck() == false) {
			errors.rejectValue("userId", "NotCheck");
		}
	}
}
