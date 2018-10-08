package com.bitehunter.model;

public class Menu {

	String mid,cName,menuName;
	double price;
	public Menu(String mid, String cName, String menuName, double price) {
		super();
		this.mid = mid;
		this.cName = cName;
		this.menuName = menuName;
		this.price = price;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
