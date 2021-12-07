package com.jwt.request;

import java.util.Collection;

public class SignUpRequest {
	
	private String userName;
	private String email;
	private String mobileNumber;
	private String pass;
	private String roles;
	
	
	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
	}


	public SignUpRequest(String userName, String email, String mobileNumber, String pass, String roles) {
		super();
		this.userName = userName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.pass = pass;
		this.roles = roles;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	@Override
	public String toString() {
		return "SignUpRequest [userName=" + userName + ", email=" + email + ", mobileNumber=" + mobileNumber + ", pass="
				+ pass + ", roles=" + roles + "]";
	}


	public SignUpRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
