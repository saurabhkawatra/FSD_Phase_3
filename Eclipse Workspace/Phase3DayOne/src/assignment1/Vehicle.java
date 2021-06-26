package assignment1;

public abstract class Vehicle {
	
	 int noofwheels;
	 String color;
	 String brand;
	 
	 abstract void drive();
	 abstract void park();
	
	 
	 
	 
	 public static void main(String[] args)
	 {
		 new Vehicle() {
			
			@Override
			void park() {
				System.out.println("This is from Vehicle annonymous object park() method");
				
			}
			
			@Override
			void drive() {
				// TODO Auto-generated method stub
				
			}
		}.park();
		
	 }
	 

}
