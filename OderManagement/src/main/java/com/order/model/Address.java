package com.order.model;

import org.springframework.data.annotation.Id;


public class Address {

	private String fullName;
	private String mobileNumber;
	private String city;
	private String state;
	private int pincode;
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	@Override
	public String toString() {
		return "Address [fullName=" + fullName + ", mobileNumber=" + mobileNumber + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + "]";
	}
	public Address(String fullName, String mobileNumber, String city, String state, int pincode) {
		super();
		this.fullName = fullName;
		this.mobileNumber = mobileNumber;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public Address() {}
	
}
