package com.cropdeal.controller;

import java.util.List;
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.apache.http.impl.bootstrap.HttpServer;
import org.bouncycastle.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropdeal.customException.ControllerException;
import com.cropdeal.customException.ServerExceptions;
import com.cropdeal.model.CropDetails;
import com.cropdeal.service.CropService;


@RestController
@RequestMapping("/cropdetails")
public class CropDetailsController {

	@Autowired
	CropService cropServiceImpl ;
	
	//save the cropdetails
	@PostMapping("/savecropdetails")
	public ResponseEntity<?> addCropDetails(@RequestBody CropDetails cropdetails){
		try {
			CropDetails cropDetails = cropServiceImpl.save(cropdetails);
			return  new ResponseEntity<CropDetails>(cropDetails,null, HttpStatus.SC_CREATED);
		}catch (ServerExceptions e) {
			ControllerException ce=  new ControllerException(e.getErrorCode(),e.getErrorMessage()); 
			return new ResponseEntity<ControllerException>(ce , null, HttpStatus.SC_BAD_REQUEST);
		}catch (Exception e) {
			ControllerException ce=  new ControllerException("612","something went wrong in Controller"); 
			return new ResponseEntity<ControllerException>(ce , null, HttpStatus.SC_BAD_REQUEST);		}
	}
	
	//find all cropdetails
	@GetMapping("/findAllcropdetails")
	public List<CropDetails> getAll(){
		return cropServiceImpl.getAll();
	}
	
	//find the cropdetails by id
	@GetMapping("/findAllCropDetails/{id}")
	public Optional<CropDetails> getCropDetails(@PathVariable int id){
		return cropServiceImpl.getCropDetailsById(id);
	}
	
	//delete the cropdetails by id
	@DeleteMapping("/delete/{id}")
	public String deleteCropDetails(@PathVariable int id) {
		cropServiceImpl.deleteCropDetails(id);
		 return "Delete cropdetails with id: "+id;
	}
	
	//update the cropdetails by id
	@PutMapping("/update/{id}")
	public String updateCropDetails(@RequestBody CropDetails cropdetails, @PathVariable int id) {
		cropServiceImpl.getCropDetailsById(id);
		cropServiceImpl.save(cropdetails);
		return "Update cropdetails with id: "+id;
		
	}
}
