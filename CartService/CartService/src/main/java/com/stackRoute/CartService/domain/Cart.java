package com.stackRoute.CartService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    private String CartId;
    private List<CartItem>cartItemList;

}
