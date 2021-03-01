package com.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String IndexController() {
		return "index";
	}

	@ResponseBody
	@GetMapping(value = "/getString")
	public String testData() {
		return "1234";
	}
}

