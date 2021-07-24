package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController{
	
	
	
	@GetMapping("/greeting")
	public String greet()
	{
		return "Hello world";
	}
	
	@PostMapping("/greeting")
	public String greet1()
	{
		return "Hello world";
	}

}
