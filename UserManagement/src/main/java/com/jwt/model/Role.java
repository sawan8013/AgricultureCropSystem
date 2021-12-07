package com.jwt.model;


import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Roles")
public class Role {
	@Id
	private int id;
	private ERole name;
	
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}



	


	public Role(int id, ERole name) {
		super();
		this.id = id;
		this.name = name;
	}






	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}






	public ERole getName() {
		return name;
	}






	public void setName(ERole name) {
		this.name = name;
	}



	
	
	
}
