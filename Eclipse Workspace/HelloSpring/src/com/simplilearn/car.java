package com.simplilearn;

public class car {
	
	private String brand;
	private String color;
	
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "car [brand=" + brand + ", color=" + color + "]";
	}
	
	

}
