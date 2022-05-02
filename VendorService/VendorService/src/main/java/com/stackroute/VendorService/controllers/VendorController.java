package com.stackroute.VendorService.controllers;
import com.stackroute.VendorService.domain.*;
import com.stackroute.VendorService.exception.*;
import com.stackroute.VendorService.service.CuisineService.CuisineService;
import com.stackroute.VendorService.service.DishService.DishService;
import com.stackroute.VendorService.service.RestaurantService.RestaurantService;
import com.stackroute.VendorService.service.VendorService.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v5/vendor/")
@CrossOrigin(origins = "http://localhost:4200")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private CuisineService cuisineService;

    @Autowired
    private DishService dishService;

    private ResponseEntity responseEntity;

    @PostMapping("register")
    public ResponseEntity<?> saveVendorDetails(@RequestBody Vendor vendor) throws VendorAlreadyExistException{

        try{
            responseEntity = new ResponseEntity<>(vendorService.saveVendorDetails(vendor), HttpStatus.OK);
        }
        catch(VendorAlreadyExistException e){
            responseEntity=new ResponseEntity<>("Email already exists",HttpStatus.CONFLICT);
        }
        catch(Exception e){
            responseEntity=new ResponseEntity<>("Try again later",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @PostMapping("editDetails/{vendorId}")
    public ResponseEntity<?>editVendorDetails(@RequestBody Vendor vendor, @PathVariable String vendorId){

        try{
            responseEntity = new ResponseEntity<>(vendorService.editVendorDetails(vendor,vendorId),HttpStatus.OK);
        }
        catch (VendorNotFoundException e){
            responseEntity = new ResponseEntity<>("vendor not found", HttpStatus.CONFLICT);
        }
        return  responseEntity;
    }

    @PostMapping("addRestaurant/{vendorId}")
    public  ResponseEntity<?> saveRestaurant(@RequestBody Restaurant restaurant, @PathVariable String vendorId){
        try{
            responseEntity = new ResponseEntity<>(restaurantService.addRestaurantDetails(restaurant,vendorId),HttpStatus.OK);
        }
        catch (VendorNotFoundException e){
            responseEntity = new ResponseEntity<>("vendor not found", HttpStatus.CONFLICT);
        }
        return  responseEntity;
    }

    @PostMapping("deleteRestaurant/{vendorId}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable String vendorId){
        try{
            responseEntity = new ResponseEntity<>(restaurantService.deleteRestaurantDetails(vendorId),HttpStatus.OK);
        }
        catch (VendorNotFoundException e){
            responseEntity = new ResponseEntity<>("vendor not found", HttpStatus.CONFLICT);
        }
        catch (RestaurantNotFoundException e){
            responseEntity = new ResponseEntity<>("Restaurant not found",HttpStatus.NOT_FOUND);
        }
        return  responseEntity;
    }

    @PostMapping("editRestaurant/{vendorId}")
    public ResponseEntity<?>editRestaurantDetails(@RequestBody Restaurant restaurant,@PathVariable String vendorId) throws VendorNotFoundException,RestaurantNotFoundException{

        try{
            responseEntity = new ResponseEntity<>(restaurantService.editRestaurantDetails(restaurant,vendorId),HttpStatus.OK);
        }
        catch (VendorNotFoundException e){
            responseEntity = new ResponseEntity<>("vendor not found", HttpStatus.CONFLICT);
        }
        catch (RestaurantNotFoundException e){
            responseEntity = new ResponseEntity<>("Restaurant not found",HttpStatus.NOT_FOUND);
        }
        return  responseEntity;

    }

    @PostMapping("addRestaurantLocation/{vendorId}")
    public ResponseEntity<?> addRestaurantLocation(@RequestBody Location location, @PathVariable String vendorId) throws VendorNotFoundException,RestaurantNotFoundException{

        try {
            responseEntity = new ResponseEntity<>(restaurantService.addRestaurantLocation(location,vendorId),HttpStatus.OK);

        }
        catch(VendorNotFoundException e){

            responseEntity = new ResponseEntity<>("vendor not found", HttpStatus.CONFLICT);
        }
        catch (RestaurantNotFoundException e){
            responseEntity = new ResponseEntity<>("Restaurant not found",HttpStatus.NOT_FOUND);

        }
        return responseEntity;
    }

    @PostMapping("addCuisine")
    public ResponseEntity<?> addCuisine(@RequestBody Cuisine cuisine){

        responseEntity = new ResponseEntity<>(cuisineService.addCuisine(cuisine),HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("getAllRestaurant")
    public ResponseEntity<?> getAllRestaurant(){

        responseEntity = new ResponseEntity<>(restaurantService.getAllRestaurant(),HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("getCuisineName/{cuisineId}")
    public ResponseEntity<?> getCuisineNames(@PathVariable String cuisineId){

        responseEntity = new ResponseEntity<>(cuisineService.getCuisineById(cuisineId),HttpStatus.OK);

        return responseEntity;

    }

    @GetMapping("getDishes/{restaurantId}")
    public ResponseEntity<?> getAllDishes(@PathVariable String restaurantId) throws RestaurantNotFoundException
    {
        try {
            responseEntity = new ResponseEntity<>(dishService.getAllDish(restaurantId), HttpStatus.OK);
        }
        catch (RestaurantNotFoundException e)
        {
            responseEntity = new ResponseEntity("Restaurant not found",HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PostMapping("addDish/{restaurantId}")
    public ResponseEntity<?> addDish(@RequestBody Dish dish, @PathVariable String restaurantId) throws RestaurantNotFoundException
    {
        try{
            responseEntity = new ResponseEntity<>(dishService.addDish(dish,restaurantId),HttpStatus.OK);
        }
        catch (RestaurantNotFoundException e)
        {
            responseEntity = new ResponseEntity("Restaurant not found",HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    @DeleteMapping("deleteDish/{dishId}/{restaurantId}")
    public ResponseEntity<?> deleteDish(@PathVariable String dishId, @PathVariable String restaurantId) throws RestaurantNotFoundException
    {
        try{
            responseEntity = new ResponseEntity<>(dishService.deleteDish(dishId,restaurantId),HttpStatus.OK);
        }
        catch (RestaurantNotFoundException e)
        {
            responseEntity = new ResponseEntity("Restaurant not found",HttpStatus.NOT_FOUND);
        }
        return responseEntity;

    }
    @GetMapping("getDish/{dishId}/{restaurantId}")
    public ResponseEntity<?> getDishByDishId(@PathVariable String dishId, @PathVariable String restaurantId) throws RestaurantNotFoundException,DishNotFoundException
    {
        try{
            responseEntity = new ResponseEntity<>(dishService.getDishByDishId(dishId,restaurantId),HttpStatus.OK);
        }
        catch (RestaurantNotFoundException e)
        {
            responseEntity = new ResponseEntity("Restaurant not found",HttpStatus.NOT_FOUND);
        }
        catch (DishNotFoundException e)
        {
            responseEntity = new ResponseEntity("Dish not found not found",HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("getRestaurantByResId/{restaurantId}")
    public ResponseEntity<?> getRestaurant(@PathVariable String restaurantId) throws RestaurantNotFoundException{
        try{
            responseEntity = new ResponseEntity<>(restaurantService.getRestaurantByResId(restaurantId),HttpStatus.OK);
        }
        catch (RestaurantNotFoundException e)
        {
            responseEntity = new ResponseEntity("Restaurant not found",HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("getRestaurantByName/{restaurantName}")
    public ResponseEntity<?> getRestaurantByName(@PathVariable String restaurantName){
        try{
            responseEntity = new ResponseEntity<>(restaurantService.getRestaurantByName(restaurantName),HttpStatus.OK);
        }
        catch(Exception e){
            responseEntity = new ResponseEntity("restaurant not found",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("getVendorByEmail/{email}")
    public ResponseEntity<?> getVendorByEmail(@PathVariable String email){
        try{
            responseEntity = new ResponseEntity<>(vendorService.getVendorByVendorEmail(email),HttpStatus.OK);
        }
        catch(Exception e){
            responseEntity = new ResponseEntity("vendor not found",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}
