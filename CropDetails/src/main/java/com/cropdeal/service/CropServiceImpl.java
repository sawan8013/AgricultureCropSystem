package com.cropdeal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropdeal.customException.ServerExceptions;
import com.cropdeal.customException.ControllerException;
import com.cropdeal.model.CropDetails;
import com.cropdeal.repository.CropDetailsRepository;

@Service
public class CropServiceImpl implements CropService{
	@Autowired
	private CropDetailsRepository cropDetailsRepository ;
	
		//save the cropdetails
		@Override
		public CropDetails save( CropDetails cropdetails) {
			
			if(cropdetails.getCropName().isEmpty() || cropdetails.getCropName().length()==0) {
				throw new ServerExceptions("601","Please send proper name, It's Blank");
			}
			try {
				CropDetails e =  cropDetailsRepository.save(cropdetails);
				return e;
			}catch (IllegalArgumentException e) {
				throw new ServerExceptions("602","Please add name, It's Null "+e.getMessage());
			}
			catch (Exception e) {
				throw new ServerExceptions("603","Something went wrong, Please recheck "+e.getMessage());
			}
		}
		
		//find all cropdetails
		@Override
		public List<CropDetails> getAll(){
			List<CropDetails> list = null;
			try {
				list = cropDetailsRepository.findAll();
				
			}catch (Exception e) {
				throw new ServerExceptions("605","Something went wrong,While fetching the data"+e.getMessage());
			}
			if(list.isEmpty())
			{
				throw new ServerExceptions("604","Crop Details is empty, We have nothing to return");
			}
			else {
				return list;	
			}
			
			
		}
		
		//find the cropdetails by id
		@Override
		public Optional<CropDetails> getCropDetailsById(int id){
			try {
				return cropDetailsRepository.findById(id);
			}catch (IllegalArgumentException e) {
				throw new ServerExceptions("606","cropId is null, Check it");
			}catch (java.util.NoSuchElementException e) {
				throw new ServerExceptions("607","cropId doesnot exist in MongoDB");
			}
			
		}
		
		//delete the cropdetails by id
		@Override 
		public String deleteCropDetails( int id) {
			try {
				cropDetailsRepository.deleteById(id);
				 return "Delete cropdetails with id: "+id;
			}catch (IllegalArgumentException e) {
				throw new ServerExceptions("608","cropId is null, Check it");
			}catch (java.util.NoSuchElementException e) {
				throw new ServerExceptions("609","cropId doesnot exist in MongoDB");
			}
			
		}
		
		//update the cropdetails by id
		@Override
		public String updateCropDetails( CropDetails cropdetails,  int id) {
			try {
				cropDetailsRepository.findById(id);
				cropDetailsRepository.save(cropdetails);
				return "Update cropdetails with id: "+id;
			}catch (IllegalArgumentException e) {
				throw new ServerExceptions("610","cropId is null, Check it");
			}catch (java.util.NoSuchElementException e) {
				throw new ServerExceptions("611","cropId doesnot exist in MongoDB");
			}
		}
}
