package kr.co.whatTodo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.whatTodo.beans.UserInfoBean;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name = "loginUserInfoBean")
	private UserInfoBean loginUserInfo;
	
	/**
	 * @desc : 로그인
	 * @return : sign.jsp
	 */
	@GetMapping("/sign")
	public String login() {
		return "sign";
	}

	/**
	 * @desc : 회원가입
	 * @return : join.jsp 
	 */
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
	/**
	 * @desc : 로그아웃
	 * @return : main.jsp
	 */
	@GetMapping("/logout")
	public String logout() {
		loginUserInfo.setIsLogin(false);
		return "main";
	}
}
