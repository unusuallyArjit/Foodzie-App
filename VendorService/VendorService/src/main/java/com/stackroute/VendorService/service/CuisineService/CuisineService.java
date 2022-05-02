package com.stackroute.VendorService.service.CuisineService;

import com.stackroute.VendorService.domain.Cuisine;

import java.util.List;

public interface CuisineService {
    public Cuisine addCuisine(Cuisine cuisine);
    public Cuisine getCuisineById(String cuisineIds);
}
