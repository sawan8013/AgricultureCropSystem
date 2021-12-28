package com.jwt.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.jwt.model.UserModel;
import com.jwt.repository.UserManagementRepo;
import com.jwt.request.AuthenticationRequest;
import com.jwt.request.AuthenticationResponse;
import com.jwt.request.SignUpRequest;
import com.jwt.service.JwtUtils;
import com.jwt.service.UserManagementService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AuthController {
	
	@Autowired
	private UserManagementRepo userManagementRepo;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserManagementService userManagementService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	// dashboard
	@GetMapping("/dashboard")
	private String welcomeToDashboard() {
		return "Welcome to the Dashboard";
	}
	
	//for signup
	@PostMapping("/signup")
	private ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest){
		if (userManagementRepo.existsByUserName(signUpRequest.getUserName())) {
			return ResponseEntity
					.badRequest()
					.body(new AuthenticationResponse("Error: Username is already taken!"));
		}

		if (userManagementRepo.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new AuthenticationResponse("Error: Email is already in use!"));
		}
		 
		//create new user's account
		UserModel userModel= new UserModel();
		userModel.setUserName(signUpRequest.getUserName());
		userModel.setEmail(signUpRequest.getEmail());
		userModel.setMobileNumber(signUpRequest.getMobileNumber());
		userModel.setPass(signUpRequest.getPass());
		userModel.setRole(signUpRequest.getRoles());
		
		try {
			userManagementRepo.save(userModel);
		}catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error During Registration!"));
		}
		
		return ResponseEntity.ok(new AuthenticationResponse("User registered successfully!"));
	}
	
	//for login
	@PostMapping("/login")
	private ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest){
		
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName()
					,authenticationRequest.getPass()));
	}catch ( Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Bad Credentials "+authenticationRequest.getUserName()));
	}
		UserDetails loadedUser =  userManagementService.loadUserByUsername(authenticationRequest.getUserName());
		String generatedToken = jwtUtils.generateToken(loadedUser);
		return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
	}
	
	//find users by email
	@GetMapping("/profile/ByEmail/{email}")
	public ResponseEntity<?>getByEmail(@PathVariable String email){
		
		Optional<UserModel> Email = userManagementRepo.findByEmail(email);
		if(Email.isEmpty()) {
			return ResponseEntity.ok(new AuthenticationResponse("Profile is not found!"));
			
		}
		return ResponseEntity.ok(Email);
	}
	
	
	//find all users
	@GetMapping("/findAllUsers")
	public ResponseEntity<?> getAll(){
		List<UserModel> users= userManagementRepo.findAll();
		if(users.isEmpty())
		{
			return ResponseEntity.ok(new AuthenticationResponse("No users are available"));
		}
		return ResponseEntity.ok(users);
	}
	
	
	//delete the UserProfile by email
	@DeleteMapping("/delete/{email}")
	public String deleteByEmail(@PathVariable String email) {
		return  userManagementService.deleteByEmail(email);
		
	}
			
//	//update the userProfile by email
//	@PutMapping("/update/{email}")
//	public String updateByEmail(@RequestBody UserModel userModel, @PathVariable String email) {
////		userManagementRepo.updateProfileDetails(userModel, email);
////		return "Update cropdetails with id: "+email;
//		
//		return userManagementRepo.updateByEmail(userModel, email);
//	}
	
}
