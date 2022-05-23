package com.example.orderservice.service;

import com.example.orderservice.domain.Cart;
import com.example.orderservice.domain.Order;


public interface OrderService {



    public Order placeOrder(String userId, Cart cart);
}
