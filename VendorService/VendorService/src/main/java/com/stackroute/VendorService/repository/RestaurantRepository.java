package com.stackroute.VendorService.repository;

import com.stackroute.VendorService.domain.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant,String> {

    @Query("{'restaurantName' : ?0}")
    public Restaurant getRestaurantByName(String restaurantName);
}
