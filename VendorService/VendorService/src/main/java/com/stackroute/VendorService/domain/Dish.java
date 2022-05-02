package com.stackroute.VendorService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {


    @Id
    private String dishId;
    private String dishName;
    private List<Integer>dishWeight;
    private List<Integer>dishPrice;
    private List<String>dishImages;
    private String cuisineId;
    private String unit;
    private boolean inStock = true;

}
