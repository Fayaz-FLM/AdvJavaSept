package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@RequestMapping("/hi")
	public String sayHi() {
		return "Hi";
	}
	
	@RequestMapping("/bye")
	@ResponseBody
	public String sayBye() {
		return "Bye!!!";
	}

}
