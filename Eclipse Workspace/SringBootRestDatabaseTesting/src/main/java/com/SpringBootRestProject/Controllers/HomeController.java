package com.SpringBootRestProject.Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class HomeController {
	
	@PostMapping("/check")
	public String check()
	{
		return "Check successful";
	}
	
	@PostMapping()
	public String upload(MultipartFile file) throws Exception
	{
		File f=new File("");
		FileReader fr=new FileReader(f);
		FileWriter fw=new FileWriter(f);
		FileInputStream fis= new FileInputStream(f);
		FileOutputStream fos=new FileOutputStream(f);
		fos.write(file.getBytes());
		
		return "";
	}
	
	
}
