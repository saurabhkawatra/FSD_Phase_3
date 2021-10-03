package springDAO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("student")
@Scope("singleton")
public class student {
	
	@Value("default name")
	private String name="Saurabh";
	@Value("default id")
	private String Id="cs083";
	@Value("default age")
	private String age="27";
	
	
	public String getName() {
		System.out.println("getName invoked");
		return name;
	}
	public void setName(String name) {
		System.out.println("setName invoked");
		this.name = name;
	}
	public String getId() {
		System.out.println("getId invoked");
		return Id;
	}
	public void setId(String id) {
		System.out.println("setId invoked");
		Id = id;
	}
	public String getAge() {
		System.out.println("getAge invoked");
		return age;
	}
	public void setAge(String age) {
		System.out.println("setAge invoked");
		this.age = age;
	}
	public student(String name, String id, String age) {
		super();
		System.out.println("Constructor invoked");
		this.name = name;
		Id = id;
		this.age = age;
	}
	
	public student() {
		super();
		
	}
	
	@Override
	public String toString() {
		return "[Student name=" + name + ", Student Id=" + Id + ", Student age=" + age + "]";
	}
	
	
	
	

}
