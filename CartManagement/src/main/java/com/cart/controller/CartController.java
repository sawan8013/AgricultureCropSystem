package com.cart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.model.Cart;
import com.cart.service.CartService;
import com.cart.service.CartServiceImp;

@CrossOrigin(origins = "http://localhost:3004")
@RestController
@RequestMapping("/api/cart")
public class CartController {
 
    @Autowired
    CartService cartService;
    
  //save the Cart
  	@PostMapping("/saveCartdetails")
  	public Cart save(@RequestBody Cart cart) {
  		return  cartService.save(cart);
  	}
  	
  	//find all Cart
  	@GetMapping("/findAllCartDetails")
  	public List<Cart> getAll(){
  		return cartService.getAllCarts();
  	}
  	
  	//find the Cart by id
  	@GetMapping("/findAllCartDetails/{id}")
  	public Optional<Cart> getCartDetails(@PathVariable int id){
  		return cartService.getCartById(id);
  	}
  	
  	//delete the Cart by id
  	@DeleteMapping("/delete/{id}")
  	public String deleteCartDetails(@PathVariable int id) {
  		cartService.deleteCartDetails(id);
  		 return "Delete Cart with id: "+id;
  	}
  	
  	//update the Cart by id
  	@PutMapping("/update/{id}")
  	public String updateCartDetails(@RequestBody Cart cart, @PathVariable int id) {
  		cartService.updateCartDetails(cart, id);
  		return "Update Cart with id: "+id;
  	}
  	
}