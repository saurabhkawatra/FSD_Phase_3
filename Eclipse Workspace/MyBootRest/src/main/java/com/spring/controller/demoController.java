package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entities.Book;

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
	
	@GetMapping("/test")
	public List<Book> test() {
		
		List<Book> booklist = new ArrayList<>();
		Book b = new Book(38929832, "Snow White", "Author", "88932");
		Book b1 = new Book("Hansel and Gretel", "Author1", "1234");
		Book b2 = new Book("Prince and the Pauper", "Author2", "4567");
		Book b3 = new Book("Heide", "Author3", "67893");
		Book b4 = new Book("The Invisible Man", "Author4", "198");
		booklist.add(b1);
		booklist.add(b2);
		booklist.add(b3);
		booklist.add(b4);
		booklist.add(b);
		
		return booklist;
		
	}
	
	@GetMapping("/idcheck/{id}/{id2}")
	public String idcheck(@PathVariable("id") String id,@PathVariable("id2") String id2)
	{
		System.out.println("id="+id);
		System.out.println("id2="+id2);
		return "run ok ";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
