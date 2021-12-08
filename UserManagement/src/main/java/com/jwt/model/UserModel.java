package com.jwt.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.client.model.Collation;

@Document(collection = "UserDetails")
public class UserModel{
	@Id
	private String id;
	private String userName;
	private String email;
	private String mobileNumber;
	private String pass;
	private String role;
	
	//private Collection<Role> roles= new ArrayList<>();

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", userName=" + userName + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", pass=" + pass + ", role=" + role + "]";
	}

	public UserModel(String id, String userName, String email, String mobileNumber, String pass, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.pass = pass;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
