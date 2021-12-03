package com.order.model;

public class CropDetails {
	
	private int cropId;
	private String cropName;
	
	public int getCropId() {
		return cropId;
	}
	public void setCropId(int cropId) {
		this.cropId = cropId;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public CropDetails(int cropId, String cropName) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
	}
	@Override
	public String toString() {
		return "CropDetails [cropId=" + cropId + ", cropName=" + cropName + "]";
	}
	public CropDetails() {}
	
	
	

}
