package util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import springDAO.student;

@Component
public class Main {
	
	@Autowired
	student s1;
	@Autowired
	student s2;
	@Autowired
	student s3;
	
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext anoappcontext= new AnnotationConfigApplicationContext("springDAO","util");
		Main main=anoappcontext.getBean(Main.class);
		
		System.out.println(main.s1);
		//main.s1.setName("This is new Name for s1");
		//main.s1.setId("This is new Id for s1");
		//main.s1.setAge("This is New Age for s1");
		//System.out.println("New s1 :: "+main.s1);
		//System.out.println("--------------------------------");
		
		System.out.println(main.s2);
		//main.s2.setName("This is new Name for s2");
		//main.s2.setId("This is new Id for s2");
		//main.s2.setAge("This is New Age for s2");
		//System.out.println("New s2 :: "+main.s2);
		//System.out.println("--------------------------------");
	
		System.out.println(main.s3);
		
		
//		main.s1.setName("This is new Name for s1");
//		main.s1.setId("This is new Id for s1");
//		main.s1.setAge("This is New Age for s1");
//		System.out.println("New s1 :: "+main.s1);
//		System.out.println("--------------------------------");
		
	}

}
