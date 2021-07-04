package com.simplilearn;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
    public static void main(String[] args) {
       
    	@SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
        
        obj.setMessage("new msg");
        
        HelloWorld obj2=context.getBean(HelloWorld.class);
        
	      car c=(car) context.getBean("car");
	      bike b=(bike) context.getBean("bike");
	      
	      System.out.println("Car Values -- "+c);
	      System.out.println("Bike Values -- "+b);
    }
}
