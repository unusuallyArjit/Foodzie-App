package com.stackroute.VendorService.repository;

import com.stackroute.VendorService.domain.Cuisine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends MongoRepository<Cuisine,String> {
}
