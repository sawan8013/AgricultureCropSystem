package com.cart;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.cart.model.Cart;
import com.cart.model.Item;
import com.cart.repository.CartRepository;
import com.cart.service.CartService;




@SpringBootTest
@RunWith(SpringRunner.class)
class CartManagementApplicationTests {
	@MockBean
	private CartRepository cartRepository;
	
	@Autowired
	private CartService cartService;
	
	
	
	// get all cart
	@Test
	public void getAllCartTest()
	{
	when(cartRepository.findAll()).thenReturn(Stream.of
	(new Cart(2,1000.0,Arrays.asList(new Item("Banana",20000.0,3))),new Cart(2,1000.0,
									Arrays.asList(new Item("Apple",10000.0,3))))
	.collect(Collectors.toList()));
	assertEquals(2,cartService.getAllCarts().size());
	}
	
	//add cart
	@Test
	public void addCart()
	{
	Cart cart = new Cart(2,1000.0,Arrays.asList(new Item("Banana",100.0,3)));
	when(cartRepository.save(cart)).thenReturn(cart);
	assertEquals(cart,cartService.save(cart));

	}
	
	@Test
   @Order(5)
   @Rollback(value = false)
   public void deleteCartTest(){
	cartRepository.deleteById(1);
	Cart cart1 = null;

	Optional<Cart> optionalCart = cartRepository.findById(2);

	if(optionalCart.isPresent()){ 
	   cart1 = optionalCart.get(); 
   }

   Assertions.assertThat(cart1).isNull();
  }

}
