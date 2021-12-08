package com.jwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.core.userdetails.User;



import com.jwt.model.UserModel;
import com.jwt.repository.UserManagementRepo;


@Service
public class UserManagementService implements UserDetailsService {
	
	@Autowired
	private UserManagementRepo userManagementRepo;

	//to check whether is particular username is present or not 
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserModel foundUser = userManagementRepo.findByUserName(userName);
		if(foundUser==null) {
			return null;
		}
		return new User(foundUser.getUserName(), foundUser.getPass(), new ArrayList<>());
		
	}
	
	
	//find the profile by email
	public Optional<UserModel>getProfileByEmail(String email){
		Optional<UserModel> Email = userManagementRepo.findByEmail(email);
		return Email;
	}

	//get all profile
	public List<UserModel> getAll() {
		List<UserModel> userList = userManagementRepo.findAll();
		return userList;
	}
	
//	//delete the UserProfile by email
//	@DeleteMapping("/delete/{email}")
//	public String deleteByEmail(@PathVariable String email) {
//		userManagementRepo.deleteByEmail(email);
//		return "Profile deleted with id: "+email;
//	}
//			
//	//update the userProfile by email
//	@PutMapping("/update/{id}")
//	public String updateByEmail(@RequestBody UserModel userModel, @PathVariable String email) {
//		userManagementRepo.updateByEmail(userModel, email);
//		return "Profile Updated with id: "+email;
//	}
	
	
	
}

