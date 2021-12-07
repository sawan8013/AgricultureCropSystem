package com.order;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.order.model.Address;
import com.order.model.CropDetails;
import com.order.model.Orders;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;

@SpringBootTest
class OderManagementApplicationTests {
	@MockBean
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderService orderService;
	
	@Test
	public void getAllOrdersTest()
	{
	when(orderRepository.findAll()).thenReturn(Stream.of
	(new Orders(1,"2021-07-25",1,200,"paytm","paid",2,1,"Mango","Anirban Dey","801374773","Kolkata","West Bengal",2334411)
	,new Orders(1,"2021-07-25",123,2347,"Paypal","Paid",2,1,"Apple","Sawan","345678","delhi","ncr",2334411))
	.collect(Collectors.toList()));
	assertEquals(2,orderService.getAllOrders().size());
	}
	
	
	@Test
	public void addOrder()
	{
		Orders order = new Orders(1,"2021-07-25",1,200,"paytm","paid",2,1,"Mango","Anirban Dey","801374773","Kolkata","West Bengal",2334411);
	when(orderRepository.save(order)).thenReturn(order);
	assertEquals(order,orderService.addOrder(order));
	}

	

}
