package com.example.loveexam;

public class Person {
	
	private int image;
	private String name,phone;
	
	
	public Person(int image, String name, String phone) {
		super();
		this.image = image;
		this.name = name;
		this.phone = phone;
		
		
	}


	public int getImage() {
		return image;
	}


	public void setImage(int image) {
		this.image = image;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
