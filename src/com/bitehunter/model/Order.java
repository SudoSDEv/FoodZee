package com.bitehunter.model;

public class Order {
	
	String usname,mids,orderId,date,phNo,total,plates,rId;

	public Order(String usname, String mids, String orderId, String date, String phNo, String total, String plates,
			String rId) {
		super();
		this.usname = usname;
		this.mids = mids;
		this.orderId = orderId;
		this.date = date;
		this.phNo = phNo;
		this.total = total;
		this.plates = plates;
		this.rId = rId;
	}

	public String getUsname() {
		return usname;
	}

	public void setUsname(String usname) {
		this.usname = usname;
	}

	public String getMids() {
		return mids;
	}

	public void setMids(String mids) {
		this.mids = mids;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getPlates() {
		return plates;
	}

	public void setPlates(String plates) {
		this.plates = plates;
	}

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}
	
	

}
