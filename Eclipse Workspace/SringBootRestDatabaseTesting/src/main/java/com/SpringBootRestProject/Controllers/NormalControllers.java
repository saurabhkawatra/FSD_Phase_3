package com.SpringBootRestProject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NormalControllers {

	@GetMapping("/inputtext")
	public String inputtext(Model model)
	{
		model.addAttribute("inputtext","THis is The Input Text");
		return "index";
	}
	
}
