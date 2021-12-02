package com.cropdeal.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cropdeal.model.CropDetails;

@Repository
public interface CropDetailsRepository extends MongoRepository<CropDetails, Integer>{

	Optional<CropDetails> findByCropName(String cropName);

	
	
}
