package com.cart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.customexception.ItemException;
import com.cart.model.Cart;
import com.cart.repository.CartRepository;


@Service
public class CartServiceImp implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	//save the cart
	@Override
	public Cart save( Cart cart) {
		if(cart.getItems().isEmpty()) {
			throw new ItemException("601","You have to provide the Item Details!");
		}
		Cart e =  cartRepository.save(cart);
		return e;
	}
	
	//find all cartDetails
		@Override
		public List<Cart> getAllCarts(){
			List<Cart> cartList = cartRepository.findAll();
			if(cartList.isEmpty()) {
				throw new ItemException("603","Cart List is completely empty");
			}
			else {
				return cartRepository.findAll();
			}
			
		}
		
	
	//find the Cart by id
	@Override
	public Optional<Cart> getCartById(int id){
		Optional<Cart> findById= cartRepository.findById(id);
		if(findById.isEmpty()) {
			throw new ItemException("602","Cart not found with this ID!");
		}else {
			return cartRepository.findById(id);
		}
	}
	
	//update the Cart by id
	@Override
	public String updateCartDetails( Cart cart,  int id) {
		boolean isCartExist = cartRepository.existsById(id);
		if(isCartExist) {
			cartRepository.save(cart);
			return "Update Cartdetails with id: "+id;
		}else {
			throw new ItemException("604","Can not Update as cart not found with this ID");
		}
		
		
	}
	
	//delete cart by id
	@Override 
	public String deleteCartDetails( int id) {
		boolean isCartExist = cartRepository.existsById(id);
		if(isCartExist) {
			cartRepository.deleteById(id);
			 return "Delete Cart details with id: "+id;
		}else {
			throw new ItemException("604","Can not delete as cart not found with this ID");
		}
		
	}
	
	
	
	/*
	 * public double getTotalPrice() { return cartRepository.t }
	 */
	
	
	
}
