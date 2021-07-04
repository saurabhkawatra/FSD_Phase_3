package springDAO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("student")
public class student {
	
	@Value("default name")
	private String name;
	@Value("default id")
	private String Id;
	@Value("deafault age")
	private String age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public student(String name, String id, String age) {
		super();
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
