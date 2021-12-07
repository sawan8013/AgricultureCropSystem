package com.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.order.customexception.OrderServiceException;
import com.order.model.Orders;
import com.order.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;
	
	//Add order
	@Override
	public Orders addOrder(Orders order) {
		if(order.getCropDetails().isEmpty()) {
			throw new OrderServiceException("601","Crop Details is empty");
		}else if (order.getAddress().isEmpty()) {
				throw new OrderServiceException("602","Address list is empty");
		}
		Orders orders =  orderRepository.save(order);
		return orders;		
		}

	//Get All orders
	@Override
	public List<Orders> getAllOrders() {
		List<Orders> allorders = orderRepository.findAll();
		if(allorders.isEmpty()) {
			throw new OrderServiceException("603","Order List is completely empty");
		}
		else {
			return allorders;
		}
	}
	
	//Get order by id
	@Override
	public Optional<Orders> getOrderById(int delarId) {
		Optional<Orders> findOrderById= orderRepository.findById(delarId);
		if(findOrderById.isEmpty()) {
			throw new OrderServiceException("604","Order not found with this ID !");
		}else {
			return orderRepository.findById(delarId) ;
		}
	}


	//delete id by id
	@Override
	public String deleteOrder(int delarId) {
		boolean isOrderExist = orderRepository.existsById(delarId);
		if(isOrderExist) {
			orderRepository.deleteById(delarId);
			return "Deleted order with id: "+delarId;
		}else {
			throw new OrderServiceException("605","Can not delete as order not found with this ID");
		}	
		
	}


	//update data with id
	@Override
	public String updateOrder(Orders order, int delarId) {
		boolean isOrderExist = orderRepository.existsById(delarId);
		if(isOrderExist) {
			orderRepository.save(order);
			return "Updated Order with id: "+delarId;
		}else {
			throw new OrderServiceException("606","Can not update as Order not found with this ID");
		}	
		
	}

	
}
