package com.searchengine.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = {"/"})
	public String index()
	{
		System.out.println("index Handler executed");
		return "index";
	}

}
