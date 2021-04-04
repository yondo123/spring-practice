package kr.co.whatTodo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.whatTodo.beans.UserInfoBean;

@Controller
public class HomeController {
	@Resource(name = "loginUserInfoBean")
	private UserInfoBean loginUserInfoBean;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() {
		System.out.println(loginUserInfoBean.getIsLogin());
		return "redirect:/main";
	}
	
}
