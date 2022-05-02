package com.stackRoute.CartService.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    private String street;
    private String landmark;
    private String state;
    private String city;
    private int zipcode;

}
