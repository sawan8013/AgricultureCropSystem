package com.cropdeal.exceptioncontroller;


import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cropdeal.customexception.CropDetailsNotFoundException;
import com.cropdeal.customexception.EmptyInputExceptions;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(EmptyInputExceptions.class)
	public ResponseEntity<String> handelEmptyInput(EmptyInputExceptions emptyInputExceptions){
		return new ResponseEntity<String>(emptyInputExceptions.getErrorMessage(), null, HttpStatus.SC_BAD_REQUEST);
	}
	
	
	@ExceptionHandler(CropDetailsNotFoundException.class)
	public ResponseEntity<String> handelNoSuchElement(CropDetailsNotFoundException cropDetailsNotFoundException){
		return new ResponseEntity<String>(cropDetailsNotFoundException.getErrorMessage(), null, HttpStatus.SC_BAD_REQUEST);
	}
}
