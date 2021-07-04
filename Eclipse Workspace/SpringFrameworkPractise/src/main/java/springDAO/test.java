package springDAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	
	
	public static void main(String[] args) {
		
		
		ApplicationContext context=new ClassPathXmlApplicationContext("springDAO/spconfig.xml");
		
		student s1= context.getBean("student",student.class);
		
		System.out.println(s1);
		
		s1.setName("sakldkas");
		s1.setId("skdkas");
		s1.setAge("4343");
		
		student s2=context.getBean("student",student.class);
		
		System.out.println("s1 = "+s1);
		System.out.println("s2 = "+s2);
	}

}
