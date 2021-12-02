package com.orderDetails.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation ="PaymentDetails")
public class AddPaymentDetails {
	private String Name;
	private String PhoneNumber;
	private String Email;
	private String PaymentMethod;
	private String Amount;
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.PhoneNumber = phoneNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getPaymentMethod() {
		return PaymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		PaymentMethod = paymentMethod;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		this.Amount = amount;
	}
	public AddPaymentDetails(String name, String phoneNumber, String email, String paymentMethod, String amount) {
		super();
		this.Name = name;
		this.PhoneNumber = phoneNumber;
		this.Email = email;
		this.PaymentMethod = paymentMethod;
		this.Amount = amount;
	}
	@Override
	public String toString() {
		return "AddPaymentDetails [Name=" + Name + ", PhoneNumber=" + PhoneNumber + ", Email=" + Email
				+ ", PaymentMethod=" + PaymentMethod + ", Amount=" + Amount + "]";
	}
	
	
}
