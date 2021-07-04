package sportyshoes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(path = "/login")
	public String home()
	{
		System.out.println("login clicked");
		
		return "login";
	}

}
