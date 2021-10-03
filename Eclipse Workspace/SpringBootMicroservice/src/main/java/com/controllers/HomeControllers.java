package com.controllers;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Models.User;
import com.Repository.UserRepository;

@Controller
public class HomeControllers {
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(path="/")
	public String index() {
		return "home";
	}
	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String homemethod() {
		return "home";
	}
	
	@RequestMapping(value= "/allusers",method = RequestMethod.GET)
	@ResponseBody
	public List<User> showallusers() {
		List<User> userlist=new ArrayList<>();
		userRepo.findAll().forEach(u -> userlist.add(u));
		return userlist;
	}
	
	@RequestMapping(value="/finduserwithID/{id}")
	@ResponseBody
	public User finduserId(@PathVariable(value = "id") int i) {
		User x=userRepo.findById(i);
//		if(x==null)
//		{
//			x=new User();
//			x.setId(0);
//			x.setEmail("na@na.com");
//			x.setUsername("na");
//			x.setPassword("na");
//		}
		return x;
	}
	
	@RequestMapping(value={"/checkusername/{username}","/checkusername"})
	@ResponseBody
	public String checkusername(@PathVariable(value = "username",required = false) String uname) {
		
		if(uname==null)
			return "blank";
		
		User x=userRepo.findByUsername(uname);
		if(x==null)
			return "available";
		else
			return "not available";
	}
	
	@RequestMapping(value={"/checkemail/{email}","/checkemail"})
	@ResponseBody
	public String checkemail(@PathVariable(value = "email",required = false) String email) {
		
		if(email==null)
			return "blank";
		
		if(!email.matches("[a-z|A-Z|0-9]+(.+[a-z|A-Z|0-9]+)?@[a-z|A-Z|0-9]+\\.(org|com|(co\\.[a-z|A-Z][a-z|A-Z]))"))
			return "invalid email";
		
		User x=userRepo.findByEmail(email);
		
		if(x==null)
			return "available";
		else
			return "not available";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/validate", method = RequestMethod.POST)
	@ResponseBody
	public String validate(@RequestParam String username,@RequestParam String password) {
		User u=userRepo.validate(username, password);
		if(u==null)
			return "Invalid credentials";
		else
			return "User validated :: "+u;
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/registernewuser")
	@ResponseBody
	public String newuser() {
		
		return "";
	}
}
