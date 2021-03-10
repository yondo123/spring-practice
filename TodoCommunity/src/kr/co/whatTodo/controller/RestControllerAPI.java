package kr.co.whatTodo.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.whatTodo.beans.UserInfoBean;
import kr.co.whatTodo.service.UserService;

@RestController
public class RestControllerAPI {
	@Autowired
	UserService userService;
	
	@GetMapping("/user/identity/{userId}")
	public String checkId(@PathVariable String userId) {
		String checkFlag = userService.userIdEx(userId);
		return checkFlag;
	}
	
	// 회원가입(Service)
	@PostMapping("/user/signup")
	public String signup(@RequestBody Map<String, Object> userData) {
		UserInfoBean userInfoBean = new UserInfoBean();
		userInfoBean.setUSER_ID(userData.get("USER_ID").toString());
		userInfoBean.setUSER_NAME(userData.get("USER_NAME").toString());
		userInfoBean.setUSER_PW(userData.get("USER_PW").toString());
		
		return "user/joinSuccess";
	}
}
