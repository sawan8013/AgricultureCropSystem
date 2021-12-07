package com.order.service;

import java.util.List;
import java.util.Optional;


import com.order.model.Orders;

public interface OrderService {
	
	List<Orders> getAllOrders();
	Orders addOrder(Orders order);
	String deleteOrder(int customerId );
	String updateOrder( Orders order , int customerId);
	Optional<Orders> getOrderById(int customerId);
}
