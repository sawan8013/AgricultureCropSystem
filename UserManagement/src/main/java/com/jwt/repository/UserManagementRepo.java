package com.jwt.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jwt.model.UserModel;

@Repository
public interface UserManagementRepo  extends MongoRepository<UserModel, String>{

	

	

	boolean existsByUserName(String userName);

	boolean existsByEmail(String email);

	Optional<UserModel> findByEmail(String email);

	UserModel findByUserName(String userName);

	String deleteByEmail(String email);
//
//	String updateByEmail(UserModel userModel, String email);

	

	

	

	

	//Optional<UserModel> findByUserName1(String userName);

	 

	


}
