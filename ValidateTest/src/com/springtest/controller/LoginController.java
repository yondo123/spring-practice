package com.springtest.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;

import com.springtest.beans.DataBean;

@Controller
public class LoginController {
	@PostMapping("/result")
	public String login(@Valid DataBean dataBean, BindingResult res) {
		System.out.println("userId : " + dataBean.getUserId());
		System.out.println("userPW : " + dataBean.getUserPw());
		System.out.println("Validation Result : " + res);

		if (res.hasErrors()) {
			for (ObjectError err : res.getAllErrors()) {
				System.out.println("Message : " + err.getDefaultMessage());
				System.out.println("Error Code : " + err.getCode());
				System.out.println("Object Name : " + err.getObjectName());
				System.out.println("--------------------------------------");
			}
			return "index";
		}
		return "registry";
	}
}
