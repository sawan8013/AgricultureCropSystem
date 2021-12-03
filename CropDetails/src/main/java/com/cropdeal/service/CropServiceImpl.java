package com.cropdeal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cropdeal.customexception.CropDetailsNotFoundException;
import com.cropdeal.customexception.EmptyInputExceptions;
import com.cropdeal.model.CropDetails;
import com.cropdeal.repository.CropDetailsRepository;

@Service
public class CropServiceImpl implements CropService{
	@Autowired
	private CropDetailsRepository cropDetailsRepository ;
	
	//save the cropdetails
	@Override
	public CropDetails save( CropDetails cropdetails) {
		if(cropdetails.getCropName().isBlank() || cropdetails.getCropName().length()== 0) {
			throw new EmptyInputExceptions("601","Input Fileds are empty");
		}
		else if (cropdetails.getPrice()<=0 ) {
			throw new EmptyInputExceptions("602","Price is always more than Zero");
		}
		CropDetails e =  cropDetailsRepository.save(cropdetails);
		return e;
	}
	
	//find all cropdetails
	@Override
	public List<CropDetails> getAll(){
		List<CropDetails> cropList = cropDetailsRepository.findAll();
		if(cropList.isEmpty()) {
			throw new EmptyInputExceptions("603","Crop List is completely empty");
		}
		else {
			return cropList;
		}
		
	}
	
	//find the cropdetails by id
	@Override
	public Optional<CropDetails> getCropDetailsById(int id){
		Optional<CropDetails> findById= cropDetailsRepository.findById(id);
		if(findById.isEmpty()) {
			throw new CropDetailsNotFoundException("604","User not found with this ID !");
		}else {
			return cropDetailsRepository.findById(id);
		}
		
	}
	
	//delete the cropdetails by id
	@Override 
	public String deleteCropDetails( int id) {
		boolean isCropExist = cropDetailsRepository.existsById(id);
		if(isCropExist) {
			cropDetailsRepository.deleteById(id);
			return "Delete cropdetails with id: "+id;
		}else {
			throw new CropDetailsNotFoundException("605","Can not delete as User not found with this ID");
		}		
	}

	
	//update the cropdetails by id
	@Override
	public String updateCropDetails( CropDetails cropdetails,  int id) {
		boolean isCropExist = cropDetailsRepository.existsById(id);
		if(isCropExist) {
			cropDetailsRepository.save(cropdetails);
			return "Update cropdetails with id: "+id;
		}else {
			throw new CropDetailsNotFoundException("606","Can not update as User not found with this ID");
		}	
	}
	
	//find the cropdetails by name
	 @Override
	 public Optional<CropDetails>getCropDetailsByName(String cropName){
			return cropDetailsRepository.findByCropName( cropName);
    }
	
	 
	 @Override
     public boolean isCropDetailsExist(int id) {
         // TODO Auto-generated method stub
         return false;
     }
	  
	 
	
}
