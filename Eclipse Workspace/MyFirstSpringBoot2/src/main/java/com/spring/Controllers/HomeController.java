package com.spring.Controllers;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class HomeController {
	
	@RequestMapping(path = {"/"})
	public String index(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("index executed");
		System.out.println("Real Path of App :: "+request.getRealPath(""));
		
		return "index";
	}
	
	@RequestMapping(path = {"/hello"})
	public String hello()
	{
		System.out.println("hello executed");
		return "hello2";
	}
	
	@RequestMapping(path = {"/test"})
	public String test()
	{
		System.out.println("test executed");
		return "testing";
	}
	
	
	@RequestMapping(path = {"/addproduct"},method = {RequestMethod.POST},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String addproduct(HttpServletRequest request,HttpServletResponse response,@RequestParam(required = false,name = "imagefile") MultipartFile imgfile)
	{
		System.out.println("executing add product method");
		
		if(imgfile.getOriginalFilename().isEmpty())
		{
			System.out.println("if condition isEmpty executed === No Image Uploaded === Setting Default image");
			
			String genfilename="default-product-image.jpg";
			System.out.println("Generated image name :: "+genfilename);
		}
		else {
			
			System.out.println("ContentType :: "+imgfile.getContentType());
			System.out.println("Uploading File --> "+imgfile.getOriginalFilename());
			
			File infile=new File(request.getRealPath("")+"Resources\\uploads\\"+"_"+imgfile.getOriginalFilename());
			
			try {
				System.out.println(request.getRealPath("")+"Resources\\uploads\\"+"_"+imgfile.getOriginalFilename());
				if(infile.exists())
				{
					System.out.println("A file already exists with same name, and that file is going to be replaced");
				}
				infile.createNewFile();
				imgfile.transferTo(infile);
				System.out.println("File was uploaded successfully");
				
			}catch(Exception e)
			{
				System.out.println("File Exception");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		
		return "";
		
	}
}
