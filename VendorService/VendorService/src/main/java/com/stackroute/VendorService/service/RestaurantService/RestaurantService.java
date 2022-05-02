package com.stackroute.VendorService.service.RestaurantService;

import com.stackroute.VendorService.domain.Dish;
import com.stackroute.VendorService.domain.Location;
import com.stackroute.VendorService.domain.Restaurant;
import com.stackroute.VendorService.domain.Vendor;
import com.stackroute.VendorService.exception.RestaurantNotFoundException;
import com.stackroute.VendorService.exception.VendorNotFoundException;

import java.util.List;

public interface RestaurantService {

    public Restaurant addRestaurantDetails(Restaurant restaurant, String vendorId) throws VendorNotFoundException;
    public Vendor deleteRestaurantDetails(String vendorId) throws VendorNotFoundException, RestaurantNotFoundException;
    public Restaurant editRestaurantDetails(Restaurant restaurant,String vendorId) throws VendorNotFoundException,RestaurantNotFoundException ;
    public Restaurant addRestaurantLocation(Location location, String vendorId) throws VendorNotFoundException,RestaurantNotFoundException;
    public List<Restaurant> getAllRestaurant();
    public Restaurant getRestaurantByResId(String restaurantId) throws RestaurantNotFoundException;
    public Restaurant getRestaurantByName(String restaurantName);
//    public Restaurant addDish(Dish dish, String restaurantId) throws RestaurantNotFoundException ;
//
//    public Restaurant deleteDish(String dishId , String restaurantId) throws RestaurantNotFoundException;
}
