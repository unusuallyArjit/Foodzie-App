package com.example.orderservice.controllers;
import com.example.orderservice.domain.Cart;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/v5/order/")
public class orderServiceController{


    @Autowired
    private OrderService orderService;



    private ResponseEntity responseEntity;


    @PostMapping("placeOrder/{userId}")
    public ResponseEntity<?> addOrder(@RequestBody Cart cart , @PathVariable String userId)
    {

       ResponseEntity responseEntity = new ResponseEntity<>(orderService.placeOrder(userId,cart),HttpStatus.OK);
       return responseEntity;
    }
}
