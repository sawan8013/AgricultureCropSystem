package com.order.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.order.model.Orders;

@Repository
public interface OrderRepository extends MongoRepository<Orders, Integer> {

	

}
