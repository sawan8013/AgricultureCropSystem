package com.orderDetails.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation ="AddressDetails") 
public class AddDeliveryAddress {
	
	private String Fullname;
	private Long PhoneNumber;
	private int pincode;
	private String State;
	private String City;
	private String BuildingName;
	private String RoadName;
	
	
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		this.Fullname = fullname;
	}
	public Long getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.PhoneNumber = phoneNumber;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		this.State = state;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		this.City = city;
	}
	public String getBuildingName() {
		return BuildingName;
	}
	public void setBuildingName(String buildingName) {
		this.BuildingName = buildingName;
	}
	public String getRoadName() {
		return RoadName;
	}
	public void setRoadName(String roadName) {
		this.RoadName = roadName;
	}
	public AddDeliveryAddress(String fullname, Long phoneNumber, int pincode, String state, String city,
			String buildingName, String roadName) {
		super();
		Fullname = fullname;
		PhoneNumber = phoneNumber;
		this.pincode = pincode;
		State = state;
		City = city;
		BuildingName = buildingName;
		RoadName = roadName;
	}
	@Override
	public String toString() {
		return "AddDeliveryAddress [Fullname=" + Fullname + ", PhoneNumber=" + PhoneNumber + ", pincode=" + pincode
				+ ", State=" + State + ", City=" + City + ", BuildingName=" + BuildingName + ", RoadName=" + RoadName
				+ "]";
	}
	public AddDeliveryAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
