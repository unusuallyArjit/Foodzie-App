package com.stackRoute.CartService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor@NoArgsConstructor
public class Favourite {

    private List<Restaurant> restaurantList;
}
