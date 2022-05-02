package com.stackRoute.CartService.service;

import com.stackRoute.CartService.domain.Favourite;
import com.stackRoute.CartService.domain.Restaurant;
import com.stackRoute.CartService.domain.User;

import java.util.List;

public interface FavouriteService
{
    public Favourite addRestaurantToFavourite(Restaurant restaurant, String userId);
//    public Favourite deleteRestaurant(String restaurantId,String userId);
    //public Favourite addRestaurantFavourite(String restaurantId,String UserId);;
    public List<Restaurant> getAllFavourite(String userId);
    public User removeRestaurantFavourite(String restaurantId,String userId);
}
