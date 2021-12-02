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

import com.cropdeal.customexception.CropDetailsNotFoundException;
import com.cropdeal.customexception.EmptyInputExceptions;
import com.cropdeal.model.CropDetails;
import com.cropdeal.service.CropService;


@RestController
@RequestMapping("/api/cropdetails")
public class CropDetailsController {

	@Autowired
	CropService cropService ;
	

	//save the cropdetails
		@PostMapping("/savecropdetails")
		public CropDetails save(@RequestBody CropDetails cropdetails) {
			return  cropService.save(cropdetails);
		}
		
		//find all cropdetails
		@GetMapping("/findAllcropdetails")
		public List<CropDetails> getAll(){
			return cropService.getAll();
		}
		
		//find the cropdetails by id
		@GetMapping("/findAllCropDetails/{id}")
		public Optional<CropDetails> getCropDetails(@PathVariable int id){
			return cropService.getCropDetailsById(id);
		}
		
		//delete the cropdetails by id
		@DeleteMapping("/delete/{id}")
		public String deleteCropDetails(@PathVariable int id) {
			cropService.deleteCropDetails(id);
			 return "Delete cropDetails with id: "+id;
		}
		
		//update the cropdetails by id
		@PutMapping("/update/{id}")
		public String updateCropDetails(@RequestBody CropDetails cropdetails, @PathVariable int id) {
			//cropService.getCropDetailsById(id);
			//cropService.save(cropdetails);
			cropService.updateCropDetails(cropdetails, id);
			return "Update cropdetails with id: "+id;
			
		}
		
		//find the cropdetails by name
	    @GetMapping("/findAllCrops/{cropName}")
	    public Optional<CropDetails> getCropDetailsByName(@PathVariable String cropName){
	        return cropService.getCropDetailsByName(cropName);
	    }

}
