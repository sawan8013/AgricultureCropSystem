package com.cart.model;

import org.springframework.data.annotation.Id;

public class Cart {
	@Id
	private int CartId;
	private double totalPrice;
	
	
	
	public int getCartId() {
		return CartId;
	}



	public void setCartId(int cartId) {
		this.CartId = cartId;
	}


	public double getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Cart(int cartId, double totalPrice) {
		super();
		this.CartId = cartId;
		this.totalPrice = totalPrice;
	}





	@Override
	public String toString() {
		return "Cart [CartId=" + CartId + ", totalPrice=" + totalPrice + "]";
	}



	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
