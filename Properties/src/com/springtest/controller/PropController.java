package com.springtest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PropertySource("/WEB-INF/properties/constant.properties")
public class PropController {
	@Value("${database.dbms}")
	private String db_service;

	@Value("${database.username}")
	private String db_username;

	@GetMapping("/properties")
	public String properties() {
		System.out.println(db_service + ", " + db_username);
		return "prop";
	}
}
