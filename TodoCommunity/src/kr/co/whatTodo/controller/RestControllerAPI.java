package kr.co.whatTodo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.whatTodo.beans.ResponseBean;
import kr.co.whatTodo.beans.UserInfoBean;
import kr.co.whatTodo.service.UserService;

@RestController
public class RestControllerAPI {
	@Autowired
	private UserService userService;

	// 회원가입(Service)
	@ResponseBody
	@GetMapping("/user/identity/{userId}")
	public ResponseEntity<ResponseBean> checkId(@PathVariable String userId) {
		Boolean existFlag = userService.userIdEx(userId);
		ResponseBean result = new ResponseBean("success userId Check", existFlag);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// 회원가입(Service)
	@ResponseBody
	@PostMapping("/user/signup")
	public ResponseEntity<ResponseBean> signup(@Valid @RequestBody UserInfoBean userData, BindingResult res) {
		System.out.println(userData.getUserId());
		if (res.hasErrors()) {
			System.out.println(res);
			ResponseBean error = new ResponseBean(res.getAllErrors().get(0).getDefaultMessage(), false);
			return new ResponseEntity<>(error, HttpStatus.OK);
		}
		// call Service
		userService.addUser(userData);
		ResponseBean success = new ResponseBean("success", true);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}
}
