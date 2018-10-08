package com.bitehunter.model;

public class Restaurant {
	
	private String rId,rName,city,address,phone,email;

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Restaurant(String rId, String rName, String city, String address, String phone, String email) {
		super();
		this.rId = rId;
		this.rName = rName;
		this.city = city;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	
	

}
