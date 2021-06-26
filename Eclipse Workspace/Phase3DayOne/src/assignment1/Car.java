package assignment1;

public class Car extends Vehicle {
	
	@Override
	void park()
	{
		System.out.println("Car is parked");
	}
	@Override
	void drive()
	{
		System.out.println("Car is being driven");
	}
	
	void setnoofwheels(int noofwheels)
	{
		this.noofwheels=noofwheels;
	}
	void setcolor(String color)
	{
		this.color=color;
	}
	void setbrand(String brand)
	{
		this.brand=brand;
	}
	
	public Car(int noofweels,String color, String brand)
	{
		this.noofwheels=noofweels;
		this.color=color;
		this.brand=brand;
	}

}
