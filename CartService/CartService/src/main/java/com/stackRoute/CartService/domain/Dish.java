package com.stackRoute.CartService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

    private String dishId;
    private String dishName;
    private List<Integer> dishWeight;
    private List<Integer>dishPrice;
    private List<String>dishImages;
    private boolean inStock = true;
}
