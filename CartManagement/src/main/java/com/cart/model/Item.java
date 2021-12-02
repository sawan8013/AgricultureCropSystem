package com.cart.model;

public class Item {
	
	private String CropName;
	private String CropPrice;
	private String CropQuantity;
	
	
	public String getCropName() {
		return CropName;
	}
	public void setCropName(String cropName) {
		this.CropName = cropName;
	}
	public String getCropPrice() {
		return CropPrice;
	}
	public void setCropPrice(String cropPrice) {
		this.CropPrice = cropPrice;
	}
	public String getCropQuantity() {
		return CropQuantity;
	}
	public void setCropQuantity(String cropQuantity) {
		this.CropQuantity = cropQuantity;
	}
	public Item(String cropName, String cropPrice, String cropQuantity) {
		super();
		this.CropName = cropName;
		this.CropPrice = cropPrice;
		this.CropQuantity = cropQuantity;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Item [CropName=" + CropName + ", CropPrice=" + CropPrice + ", CropQuantity=" + CropQuantity + "]";
	}
	
	
}
