package kr.co.whatTodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.whatTodo.validator.UserValidator;

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
}
