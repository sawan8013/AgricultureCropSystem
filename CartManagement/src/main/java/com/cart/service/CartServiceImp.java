package com.cart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.model.Cart;
import com.cart.repository.CartRepository;

@Service
public class CartServiceImp implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	//save the cart
	@Override
	public Cart save( Cart cart) {
		Cart e =  cartRepository.save(cart);
		return e;
	}
	
	
	//find the Cart by id
	@Override
	public Optional<Cart> getCartById(int id){
		return cartRepository.findById(id);
	}
	
	//update the Cart by id
	@Override
	public String updateCartDetails( Cart cart,  int id) {
		cartRepository.findById(id);
		cartRepository.save(cart);
		return "Update Cartdetails with id: "+id;
		
	}
	
	//delete by id
	@Override 
	public String deleteCartDetails( int id) {
		cartRepository.deleteById(id);
		 return "Delete Cartdetails with id: "+id;
	}
	
	//find all cartDetails
	@Override
	public List<Cart> getAllCarts(){
		return cartRepository.findAll();
	}
	
	/*
	 * public double getTotalPrice() { return cartRepository.t }
	 */
	
	
	
}
