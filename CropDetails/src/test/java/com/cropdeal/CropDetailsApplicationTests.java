package com.cropdeal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cropdeal.customexception.EmptyInputExceptions;
import com.cropdeal.model.CropDetails;
import com.cropdeal.model.Location;
import com.cropdeal.repository.CropDetailsRepository;
import com.cropdeal.service.CropService;
import com.mongodb.assertions.Assertions;

@RunWith(SpringRunner.class)
@SpringBootTest
class CropDetailsApplicationTests {
	
	@Autowired
	private CropService cropService;
	
	@MockBean
	private CropDetailsRepository cropDetailsRepository;
	
	//CropService cropService1;
	
	
	//get All Crop Details
	@Test
	public void getAllCropTest() {
		when(cropDetailsRepository.findAll()).thenReturn((List<CropDetails>) Stream.of
				(new CropDetails(1,"Banana","Fruit","7kg",900, new Location("Sheoraphuli","Amarabati","Kolkata","West Bengal","712223"),"Sawan Kundu"),
					new	CropDetails(2,"Mango","Fruit","9kg",1000, new Location("Shefrraphuli","Aaarabati","Kolkataa","West Bengal","712223"),"Sawan Kundu")	
				).collect(Collectors.toList()));
				
				assertEquals(2,cropService.getAll().size());
	}
	
	//add Crop Details
	@Test
	public void addCrop() throws EmptyInputExceptions{
		CropDetails cropDetails =new CropDetails(1,"Banana","Fruit","7kg",900, 
				new Location("Sheoraphuli","Amarabati","Kolkata","West Bengal","712223"),"Sawan Kundu");
		when(cropDetailsRepository.save(cropDetails)).thenReturn(cropDetails);
		assertEquals(cropDetails,cropService.save(cropDetails));
		
	}
	
	
	//get crop by id
//	@Test
//	public void getDeleteById() throws EmptyInputExceptions{
//		int i=1;
//		when(cropService.deleteCropDetails(i)).thenReturn((List<CropDetails>) Stream.of
//				(new CropDetails(1,"Banana","Fruit","7kg",900, new Location("Sheoraphuli","Amarabati",
//						"Kolkata","West Bengal","712223"),"Sawan Kundu")).collect(Collectors.toList()));
//		
//	}
	
	
}
