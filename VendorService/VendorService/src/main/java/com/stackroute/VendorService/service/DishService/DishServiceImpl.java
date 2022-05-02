package com.stackroute.VendorService.service.DishService;

import com.stackroute.VendorService.domain.Dish;
import com.stackroute.VendorService.domain.Restaurant;
import com.stackroute.VendorService.exception.DishNotFoundException;
import com.stackroute.VendorService.exception.RestaurantNotFoundException;
import com.stackroute.VendorService.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService{


    @Autowired
    private RestaurantRepository restaurantRepository;




    @Override
    public Restaurant addDish(Dish dish, String restaurantId) throws RestaurantNotFoundException{

        dish.setDishId(UUID.randomUUID().toString());
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        List<Dish> dishList = restaurant.getDishList();
        if(dishList==null)
            dishList = new ArrayList<>();
        dishList.add(dish);
        restaurant.setDishList(dishList);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant deleteDish(String dishId, String restaurantId) throws RestaurantNotFoundException{

        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        List<Dish> dishList = restaurant.getDishList();
        if(dishList==null)
            dishList = new ArrayList<>();
        List<Dish> newDishList = dishList.stream().filter(data->data.getDishId().equals(dishId)).collect(Collectors.toList());
        dishList.remove(newDishList.get(0));
//        for(int i = 0;i < dishList.size();i++) {
//
//            if (dishList.get(i).getDishId() != dishId) {
//                newDishList.add(dishList.get(i));
//            }
//        }
        restaurant.setDishList(dishList);
        return restaurantRepository.save(restaurant);

    }

    @Override
    public List<Dish> getAllDish(String restaurantId) throws RestaurantNotFoundException {
        if(restaurantRepository.findById(restaurantId).isEmpty())
            throw new RestaurantNotFoundException();
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        List<Dish> dishList = restaurant.getDishList();
        return dishList;
    }

    @Override
    public Dish getDishByDishId(String dishId,String restaurantId) throws RestaurantNotFoundException,DishNotFoundException {
        if(restaurantRepository.findById(restaurantId).isEmpty())
            throw new RestaurantNotFoundException();
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        List<Dish> dishList = restaurant.getDishList();
        if(dishList==null)
            dishList=new ArrayList<>();
        List<Dish> dishList1 = dishList.stream().filter(data->data.getDishId().equals(dishId)).collect(Collectors.toList());
        if(dishList1 == null)
            throw new DishNotFoundException();
        Dish dish = dishList1.get(0);
        return dish;
    }
}
