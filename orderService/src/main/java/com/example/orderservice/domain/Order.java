package com.example.orderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import java.util.Date;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {


    @Id
    private String orderId;
    private String userId;
    private String restaurantId;
    private Date createdAt;
    private Cart cart;
    double TotalAmount;
}
