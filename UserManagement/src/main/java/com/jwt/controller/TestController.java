package com.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.model.UserModel;
import com.jwt.repository.UserManagementRepo;
@RestController
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	private UserManagementRepo userManagementRepo;
	
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/farmer")
	@PreAuthorize("hasRole('FARMER')or hasRole('ADMIN')")
	public String farmerAccess() {
		
			return "Farmer Content.";
	
	}

	@GetMapping("/delar")
	@PreAuthorize("hasRole('DELAR')")
	public String delarAccess() {
		return "Delar Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
	@GetMapping("/allUsers")
	public List<UserModel> getUsers(){
		return userManagementRepo.findAll();
	}

}
