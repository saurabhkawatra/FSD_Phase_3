package com.simplilearn;

public class bike {
	
	private String company;
	private String color;
	
	
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "bike [company=" + company + ", color=" + color + "]";
	}

}
