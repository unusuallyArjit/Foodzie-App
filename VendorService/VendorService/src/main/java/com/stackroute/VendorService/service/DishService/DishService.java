package com.stackroute.VendorService.service.DishService;

import com.stackroute.VendorService.domain.Dish;
import com.stackroute.VendorService.domain.Restaurant;
import com.stackroute.VendorService.exception.DishNotFoundException;
import com.stackroute.VendorService.exception.RestaurantNotFoundException;

import java.util.List;

public interface DishService {

    public Restaurant addDish(Dish dish, String restaurantId) throws RestaurantNotFoundException;
    public Restaurant deleteDish(String dishId, String restaurantId) throws RestaurantNotFoundException;
    public List<Dish> getAllDish(String restaurantId) throws RestaurantNotFoundException;
    public Dish getDishByDishId(String dishId,String restaurantId) throws RestaurantNotFoundException,DishNotFoundException;
}
