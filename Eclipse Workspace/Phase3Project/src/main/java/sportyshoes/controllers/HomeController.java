package sportyshoes.controllers;



import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import sportyshoes.DAO.UserDAO;
import sportyshoes.MODELS.Product;
import sportyshoes.MODELS.User;
import sportyshoes.SERVICE.ProductSERVICE;
import sportyshoes.SERVICE.UserSERVICE;

@Controller
public class HomeController {
	
	@Autowired
	private UserSERVICE userService;
	@Autowired
	private ProductSERVICE productService;
	
	@RequestMapping(path = "/login")
	public String home(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("executing login clicked");
		System.out.println("request.getServletPath() :: "+request.getServletPath());
		System.out.println("request.getPathInfo() :: "+request.getPathInfo());
		System.out.println("request.getPathTranslated() :: "+request.getPathTranslated());
		System.out.println("request.getRealPath('') :: "+request.getRealPath(""));
		
		return "login";
	}
	
	@RequestMapping(path = {"/signin"},method = {RequestMethod.POST})
	public String signin(HttpServletRequest request,HttpServletResponse response,Model model,@RequestParam(name = "username")String uname,@RequestParam("password")String pass)
	{
		System.out.println("executing signing in");
		System.out.println("PathTranslated :: "+request.getPathTranslated());
		System.out.println("request.getParameter(\"username\") username entered = "+request.getParameter("username"));
		System.out.println("model.getAttribute(\"username\")= "+ model.getAttribute("username"));
		System.out.println("requestparam(name = \"username\")= "+uname);
		System.out.println("request.getParameter(\"password\") password entered = "+request.getParameter("password"));
		System.out.println("model.getAttribute(\"password\")= "+model.getAttribute("password"));
		System.out.println("requestparam(name = \"password\")= "+pass);
		System.out.println("Checking Login Credentials...");
		
		User u1=userService.login(uname, pass);
		System.out.println("Received User :: "+u1);
		
		if(u1==null) {
				System.out.println("Login Invalidated :: Invalid Username or Password!");
				return "redirect:login";
		}else if(u1.getUser_type().equals("admin")){
			System.out.println("Admin Login Validated :: Admin Name :: "+u1.getUser_Realname()+" logging in...");
			request.getSession(true).setAttribute("user_admin", u1);
			return "redirect:admin/admin-home";
		}else {
			request.getSession(true).setAttribute("user_customer", u1);
			System.out.println("Customer Login Validated :: Customer Name :: "+u1.getUser_Realname()+" logging in...");
			return "";
		}
		
	}
	
	@RequestMapping(path = {"/register"},method = {RequestMethod.POST})
	public String register(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("executing /register");
		 String dob=request.getParameter("dob");
		 System.out.println("Entered DOB = "+dob);
		 Date user_dob = new Date();
		 try {
		 user_dob=new SimpleDateFormat("yyyy-MM-dd").parse(dob);
		 }catch(Exception e)
		 {
			 System.out.println("Date Exception");
			 System.out.println(e.getMessage());
			 e.printStackTrace();
		 }
		 
		User u1=new User(request.getParameter("name"), request.getParameter("username"), request.getParameter("password"),"customer",request.getParameter("phonenumber"), request.getParameter("city"),user_dob);
		System.out.println("Details received from Form : "+u1);
		String msg=userService.addUser(u1);
		System.out.println("msg :: "+msg);
		String usrname=u1.getUsername();
		usrname=usrname.concat("_"+String.valueOf(u1.getUser_id()));
		System.out.println("Genrated username = " +usrname);
		u1.setUsername(usrname);
		String msg2=userService.updateUser(u1.getUser_id(), u1);
		System.out.println("msg2 :: "+msg2);
		return "";
		//return "registerred";
	}
	
	@RequestMapping(path = {"/logout"},method = {RequestMethod.POST})
	public String logout(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("Executing logout..");
		
		try {
			System.out.println("admin logging out "+(User)request.getSession(false).getAttribute("user_admin"));
			System.out.println("customer logging out "+(User)request.getSession(false).getAttribute("user_customer"));
			request.getSession(false).invalidate();
		}catch(Exception e) {
			System.out.println("Logout Exception");
			System.out.println("Exception Message "+e.getMessage());
		}
		
		return "redirect:/";
	}
	
	
	

}
