package kr.co.whatTodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
