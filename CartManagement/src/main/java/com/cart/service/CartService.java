package com.cart.service;

import java.util.List;
import java.util.Optional;

import com.cart.model.Cart;

public interface CartService {
	public Cart save( Cart cart);
	public Optional<Cart> getCartById(int id);
	public String updateCartDetails( Cart cart,  int id);
	public List<Cart> getAllCarts();
	public String deleteCartDetails( int id);
}
