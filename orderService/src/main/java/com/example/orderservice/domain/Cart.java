package com.example.orderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    private String CartId;
    private List<CartItem>cartItemList;

}