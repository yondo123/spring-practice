package kr.co.whatTodo.controller;

import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.whatTodo.beans.ResponseBean;
import kr.co.whatTodo.beans.UserInfoBean;
import kr.co.whatTodo.service.UserService;
import kr.co.whatTodo.validator.UserValidator;

@RestController
public class RestControllerAPI {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MessageSource errorMessage;

	@Resource(name = "loginUserInfoBean")
	private UserInfoBean loginUserInfo;
	
	//ID중복검사(Service)
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@GetMapping("/user/identity/{userId}")
	public ResponseEntity<ResponseBean> checkId(@PathVariable String userId) {
		Boolean existFlag = userService.userIdEx(userId);
		ResponseBean result = new ResponseBean("success userId Check", existFlag);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// 회원가입(Service)
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@PostMapping("/user/signup")
	public ResponseEntity<ResponseBean> signup(@Valid @RequestBody UserInfoBean userData, BindingResult res) {

		if (res.hasErrors()) {
			ResponseBean error = new ResponseBean(errorMessage.getMessage(res.getAllErrors().get(0),Locale.getDefault()), false);
			return new ResponseEntity<>(error, HttpStatus.OK);
		}
		// call Service
		userService.addUser(userData);
		ResponseBean success = new ResponseBean("success", true);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}
	
	//로그인 reqeust(Service)
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@PostMapping("/user/signin")
	public ResponseEntity<ResponseBean> signin(@Valid @RequestBody UserInfoBean loginUserInfoBean, BindingResult res){
		if(res.hasErrors()) {
			ResponseBean error = new ResponseBean(errorMessage.getMessage(res.getAllErrors().get(0),Locale.getDefault()), false);
			return new ResponseEntity<>(error, HttpStatus.OK);
		}
		userService.login(loginUserInfoBean);
		//로그인 성공유무
		if(loginUserInfo.getIsLogin()) {
			ResponseBean success = new ResponseBean("success", true);
			return new ResponseEntity<>(success, HttpStatus.OK);
		}else {
			ResponseBean fail = new ResponseBean("fail", false);
			return new ResponseEntity<>(fail, HttpStatus.OK);
		}
	}
	
	// 추가적인 요청 (custom validator)
	@InitBinder
	public void iniBinder(WebDataBinder binder) {
		UserValidator userValidator = new UserValidator();
		binder.addValidators(userValidator);
	}
}
