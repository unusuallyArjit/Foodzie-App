package com.example.orderservice.repository;

import com.example.orderservice.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {
        @Query("{'orderId' : ?0}")
        Order placeOrder(String orderId);
}
