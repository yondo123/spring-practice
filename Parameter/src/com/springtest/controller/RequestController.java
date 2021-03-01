package com.springtest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class RequestController {

	// GET
	@GetMapping("/test")
	public String test(HttpServletRequest request) {
		// 단일 파라미터
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		System.out.println(data1 + '\n' + data2);
		// 다중 파라미터
		String[] dupData = request.getParameterValues("dupData");
		for (String val : dupData) {
			System.out.println("username : " + val);
		}
		return "result";
	}

	// POST
	@PostMapping("/postResult")
	public String postResult(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String[] userHobby = request.getParameterValues("hobby");
		System.out.println("username, userid : " + userName + ", " + userId);
		if (userHobby != null) {
			for (String hobby : userHobby) {
				System.out.println("취미 : " + hobby);
			}
		}
		return "result";
	}

	// WebRequest GET
	@GetMapping("/webReqTest")
	public String webReqTest(WebRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		System.err.println(data1 + ", " + data2);
		return "result";
	}

	// @pathVariable
	@GetMapping("/board/{subPath}/{detailPath}")
	public String values(@PathVariable String subPath, @PathVariable String detailPath) {

		System.out.println("중분류 :" + subPath);
		System.out.println("소분류 :" + detailPath);
		return "result";
	}
	
	
	//requestparam
	@GetMapping("/football")
	public String post(@RequestParam String post, @RequestParam String user) {
		System.out.println("post number : " + post);
		System.out.println("post writer : " + user);
		return "result";
	}
}
