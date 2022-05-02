package com.stackRoute.CartService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor@AllArgsConstructor
public class Restaurant
{
    @Id
    private String restaurantId;
    private String restaurantVendorId;
    private String restaurantName;
    private List<String> restaurantImages;
    private List<String> CuisineIds;
    private List<Dish>dishList;
    private Location restaurantLocation;
}
