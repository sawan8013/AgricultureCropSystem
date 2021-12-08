package com.order.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.order.model.Orders;
import com.order.service.OrderService;

@RestController
@RequestMapping("/api/dealer")
public class OrderController {
	
	@Autowired
	OrderService orderservice;
	
	//adding order details
	@PostMapping("/addOrder")
	public Orders addOrder(@RequestBody Orders order) {
		return orderservice.addOrder(order);
	}

	//get all order
	@GetMapping("/getAllOrder")
	public List<Orders> getAllOrders(){
		return orderservice.getAllOrders();
	}
	
	//get order by id
	@GetMapping("/getById/{delarId}")
	public Optional<Orders> getOrderById(@PathVariable int delarId){
		return orderservice.getOrderById(delarId);
	}

	//delete by id
	@DeleteMapping("/deleteById/{delarId}")
	public String deleteOrder(@PathVariable int delarId ) {
		return orderservice.deleteOrder(delarId);
	}
	
	//update Order By Id
	@PutMapping("/updateOrderById/{delarId}")
	public String updateOrder(@RequestBody Orders order ,@PathVariable int delarId) {
		return orderservice.updateOrder(order, delarId);
	}
	
	
}
