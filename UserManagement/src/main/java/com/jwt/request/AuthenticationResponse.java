package com.jwt.request;

public class AuthenticationResponse {
	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public AuthenticationResponse(String response) {
	
		this.response = response;
	}
	
	public AuthenticationResponse() {}
}
