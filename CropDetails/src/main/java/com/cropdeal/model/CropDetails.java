package com.cropdeal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection="CropDetails")
@Data
public class CropDetails {
//	@Transient
//	public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	private int cropID;
	private String cropName;
	private String cropType;
	private String crop_quantity;
	private float price;
	private Location location; 
	private String uploadedBy;
	
	public String getCropType() {
		return cropType;
	}


	public void setCropType(String cropType) {
		this.cropType = cropType;
	}


	public String getCrop_quantity() {
		return crop_quantity;
	}


	public void setCrop_quantity(String crop_quantity) {
		this.crop_quantity = crop_quantity;
	}

	public CropDetails() {}
	

	public CropDetails(int cropID, String cropName, String cropType, String crop_quantity, float price,
			Location location, String uploadedBy) {
		super();
		this.cropID = cropID;
		this.cropName = cropName;
		this.cropType = cropType;
		this.crop_quantity = crop_quantity;
		this.price = price;
		this.location = location;
		this.uploadedBy = uploadedBy;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public int getCropID() {
		return cropID;
	}
	public void setCropID(int cropID) {
		this.cropID = cropID;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
//	public static String getSequenceName() {
//		return SEQUENCE_NAME;
//	}


	@Override
	public String toString() {
		return "CropDetails [cropID=" + cropID + ", cropName=" + cropName + ", cropType=" + cropType
				+ ", crop_quantity=" + crop_quantity + ", price=" + price + ", location=" + location + ", uploadedBy="
				+ uploadedBy + "]";
	}
	
	
}
