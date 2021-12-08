package com.order.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "Orders")
public class Orders {
	@Id
	private int orderId;
	
	@JsonFormat(pattern="yyyy-MM-dd") 
	private LocalDate orderDate;
	
	private int customerId;
	private double amountPaid;
	private String modeOfPayment;
	private String orderStatus;
	private int quantity;
	private List<CropDetails>cropDetails=new ArrayList<>();
	private List<Address>address=new ArrayList<>();
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public List<CropDetails> getCropDetails() {
		return cropDetails;
	}
	public void setCropDetails(List<CropDetails> cropDetails) {
		this.cropDetails = cropDetails;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId
				+ ", amountPaid=" + amountPaid + ", modeOfPayment=" + modeOfPayment + ", orderStatus=" + orderStatus
				+ ", quantity=" + quantity + ", cropDetails=" + cropDetails + ", address=" + address + "]";
	}
	public Orders(int orderId, LocalDate orderDate, int customerId, double amountPaid, String modeOfPayment,
			String orderStatus, int quantity, List<CropDetails> cropDetails, List<Address> address) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.amountPaid = amountPaid;
		this.modeOfPayment = modeOfPayment;
		this.orderStatus = orderStatus;
		this.quantity = quantity;
		this.cropDetails = cropDetails;
		this.address = address;
	}
	
	public Orders() {}
	public Orders(int i, String string, int j, int k, String string2, String string3, int l, int m, String string4,
			String string5, String string6, String string7, String string8, int n) {
		// TODO Auto-generated constructor stub
	}
	
	
}
