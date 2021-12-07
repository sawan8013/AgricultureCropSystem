package com.jwt.request;

public class AuthenticationRequest {
	
	private String userName;
	private String pass;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public AuthenticationRequest(String userName, String pass) {
		super();
		this.userName = userName;
		this.pass = pass;
	}
	public AuthenticationRequest() {}
	
	
}
