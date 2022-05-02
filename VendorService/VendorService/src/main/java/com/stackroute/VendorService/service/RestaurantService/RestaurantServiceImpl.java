package com.stackroute.VendorService.service.RestaurantService;

import com.stackroute.VendorService.domain.*;
import com.stackroute.VendorService.exception.RestaurantNotFoundException;
import com.stackroute.VendorService.exception.VendorNotFoundException;
import com.stackroute.VendorService.repository.CuisineRepository;
import com.stackroute.VendorService.repository.RestaurantRepository;
import com.stackroute.VendorService.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CuisineRepository cuisineRepository;

    @Override
    public Restaurant addRestaurantDetails(Restaurant restaurant, String vendorId) throws VendorNotFoundException {

        if(vendorRepository.findById(vendorId).isEmpty() || vendorId == null){
            throw  new VendorNotFoundException();
        }
        String r_id = UUID.randomUUID().toString();
        List<String> cuisineIds = restaurant.getCuisineIds();
        if(cuisineIds==null)
            cuisineIds = new ArrayList<>();
        for(int i  = 0;i < cuisineIds.size();i++){

            String cuisineId = cuisineIds.get(i);
            Cuisine cuisine = cuisineRepository.findById(cuisineId).get();
            List<String>restaurantIds = cuisine.getRestaurantIds();
            if(restaurantIds == null)
                restaurantIds = new ArrayList<>();
            restaurantIds.add(r_id);
            cuisine.setRestaurantIds(restaurantIds);
            cuisineRepository.save(cuisine);
        }


        restaurant.setRestaurantId(r_id);
        restaurant.setRestaurantVendorId(vendorId);
        Vendor vendor = vendorRepository.findById(vendorId).get();
        vendor.setRestaurantId(r_id);
        restaurant.setRestaurantVendorId(vendorId);
        vendorRepository.save(vendor);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Vendor deleteRestaurantDetails(String vendorId) throws VendorNotFoundException, RestaurantNotFoundException {
        if(vendorRepository.findById(vendorId).isEmpty() || vendorId == null){
            throw new VendorNotFoundException();
        }
        Vendor vendor = vendorRepository.findById(vendorId).get();
        String r_id = vendor.getRestaurantId();
        if(r_id == null)
            throw new RestaurantNotFoundException();
        vendor.setRestaurantId(null);
        restaurantRepository.deleteById(r_id);
        return vendorRepository.save(vendor);
    }


    @Override
    public Restaurant editRestaurantDetails(Restaurant restaurant,String vendorId) throws VendorNotFoundException,RestaurantNotFoundException {

        if(vendorRepository.findById(vendorId).isEmpty() || vendorId == null){
            throw new VendorNotFoundException();
        }

        Vendor vendor = vendorRepository.findById(vendorId).get();
        String r_id = vendor.getRestaurantId();
        if(r_id == null)
            throw  new RestaurantNotFoundException();
        restaurant.setRestaurantId(r_id);
        return restaurantRepository.save(restaurant);
    }


    @Override
    public Restaurant addRestaurantLocation(Location location, String vendorId) throws VendorNotFoundException,RestaurantNotFoundException {

        if(vendorRepository.findById(vendorId).isEmpty() || vendorId == null){
            throw new VendorNotFoundException();
        }
        Vendor vendor = vendorRepository.findById(vendorId).get();
        String r_id = vendor.getRestaurantId();
        if(r_id == null){
            throw new RestaurantNotFoundException();
        }
        Restaurant restaurant = restaurantRepository.findById(r_id).get();
        restaurant.setRestaurantLocation(location);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {

        List<Restaurant> restaurantList = restaurantRepository.findAll();
        return restaurantList;
    }

    @Override
    public Restaurant getRestaurantByResId(String restaurantId) throws RestaurantNotFoundException {
        if(restaurantRepository.findById(restaurantId).isEmpty())
            throw new RestaurantNotFoundException();
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        return restaurant;
    }

    @Override
    public Restaurant getRestaurantByName(String restaurantName) {

        return restaurantRepository.getRestaurantByName(restaurantName);
    }

//    @Override
//    public Restaurant addDish(Dish dish, String restaurantId) throws RestaurantNotFoundException
//    {
//        dish.setDishId(UUID.randomUUID().toString());
//        if(restaurantRepository.findById(restaurantId).isEmpty())
//            throw new RestaurantNotFoundException();
//        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
//        List<Dish> dishList = restaurant.getDishList();
//        if(dishList==null)
//            dishList = new ArrayList<>();
//        dishList.add(dish);
//        restaurant.setDishList(dishList);
//        return restaurantRepository.save(restaurant);
//    }
//
//    @Override
//    public List<Dish> getAllDish(String restaurantId) throws RestaurantNotFoundException
//    {
//        if(restaurantRepository.findById(restaurantId).isEmpty())
//            throw new RestaurantNotFoundException();
//        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
//        List<Dish> dishList = restaurant.getDishList();
//        return dishList;
//    }
//
//    @Override
//    public Restaurant deleteDish(String dishId, String restaurantId) throws RestaurantNotFoundException {
//        if(restaurantRepository.findById(restaurantId).isEmpty())
//            throw new RestaurantNotFoundException();
//        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
//        List<Dish> dishList = restaurant.getDishList();
//        List<Dish> dishList1 = new ArrayList<Dish>();
//        if(dishList==null)
//            dishList = new ArrayList<>();

//        for(int i=0;i<dishList.size();i++)
//        {
//            if(!dishList.get(i).getDishId().equals(dishId))
//                dishList1.add(dishList.get(i));
//        }
//        restaurant.setDishList(dishList1);
//        restaurantRepository.save(restaurant);
//        return restaurant;
//    }


}
