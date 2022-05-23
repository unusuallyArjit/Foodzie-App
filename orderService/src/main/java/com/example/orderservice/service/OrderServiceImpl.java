package com.example.orderservice.service;

import com.example.orderservice.domain.Cart;
import com.example.orderservice.domain.CartItem;
import com.example.orderservice.domain.Dish;
import com.example.orderservice.domain.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class OrderServiceImpl implements OrderService {





   @Autowired
   private OrderRepository orderRepository;
    @Override
    public Order placeOrder(String userId, Cart cart) {
        Order order = new Order();
        order.setUserId(userId);
        List<CartItem> cartItemList = new ArrayList<CartItem>(cart.getCartItemList());
        for(CartItem cartItem : cartItemList )
        {
            if(cartItem.getRestaurantId()!=null)
            {
                order.setRestaurantId(cartItem.getRestaurantId());
                break;
            }
        }
        order.setOrderId(UUID.randomUUID().toString());
        order.setCart(cart);
        double amount =0;
        for(CartItem cartItem : cartItemList)
        {
            Dish dish = cartItem.getDish();
            int weight = cartItem.getWeight();
            int dishQuantity = cartItem.getDishQuantity();
            List<Integer> dishPrices = dish.getDishPrice();
            List<Integer> dishWeights = dish.getDishWeight();
            int index =  dishWeights.indexOf(weight);
            Integer dishPrice = dishQuantity*dishPrices.get(index);
            amount = dishPrice;
        }
        order.setTotalAmount(amount);
        order.setCreatedAt(new Date());
        return orderRepository.save(order);
    }
}
