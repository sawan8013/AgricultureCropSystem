package com.jwt.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.model.ERole;
import com.jwt.model.Role;
import com.jwt.model.UserModel;
import com.jwt.repository.UserManagementRepo;
import com.jwt.request.AuthenticationRequest;
import com.jwt.request.AuthenticationResponse;
import com.jwt.request.SignUpRequest;
import com.jwt.service.JwtUtils;
import com.jwt.service.UserManagementService;

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
	
	@GetMapping("/dashboard")
	private String welcomeToDashboard() {
		return "Welcome to the Dashboard";
	}
	
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
		
//		Collection<String> strRoles= signUpRequest.getRoles();
//		Collection<Role> roles= new ArrayList<>();
//		
//		if(strRoles==null) {
//			Role userRoles= RoleRepository.findByName(ERole.Farmer)
//		}
		
		try {
			userManagementRepo.save(userModel);
		}catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error During Registration!"));
		}
		
		return ResponseEntity.ok(new AuthenticationResponse("User registered successfully!"));
	}
	
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
}
