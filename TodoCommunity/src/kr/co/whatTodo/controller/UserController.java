package kr.co.whatTodo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.whatTodo.beans.UserInfoBean;

@Controller
@RequestMapping("/user")
public class UserController {
	// 로그인
	@GetMapping("/sign")
	public String login() {
		return "sign";
	}

	// 회원가입
	@GetMapping("/join")
	public String join() {
		return "join";
	}

	// 회원가입(Service)
	@PostMapping("/signup")
	public String signup(@Valid @RequestBody Map<String, Object> userData, BindingResult res) {
		UserInfoBean userInfo = new UserInfoBean();
		if (res.hasErrors()) {
			return "user/join";
		} 
		return "user/joinSuccess";
	}

	// 로그아웃

	// 로그인(Service)

	// 로그아웃(Service)

}
