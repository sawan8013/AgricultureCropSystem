package com.jwt.exceptioncontroller;


import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jwt.customexception.UserManagementException;




@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(UserManagementException.class)
	public ResponseEntity<String> handelEmptyInput(UserManagementException userManagementException){
		return new ResponseEntity<String>(userManagementException.getErrMess(), null, HttpStatus.SC_BAD_REQUEST);
	}
	
	

}
