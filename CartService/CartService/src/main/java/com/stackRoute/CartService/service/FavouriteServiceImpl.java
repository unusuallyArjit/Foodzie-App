package com.stackRoute.CartService.service;

import com.stackRoute.CartService.domain.Favourite;
import com.stackRoute.CartService.domain.Restaurant;
import com.stackRoute.CartService.domain.User;
import com.stackRoute.CartService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    UserRepository userRepository;


    @Override
    public Favourite addRestaurantToFavourite(Restaurant restaurant, String userId) {
        if(userRepository.findById(userId).isEmpty())
            System.out.println("not found");
        User user =  userRepository.findById(userId).get();
        Favourite favourite = user.getFavourite();

        if(favourite == null)
            favourite = new Favourite();
        List<Restaurant> restaurantList = favourite.getRestaurantList();
        if(restaurantList==null)
            restaurantList = new ArrayList<>();

        //List<Restaurant> restaurantList1 = restaurantList.stream().filter(data->data.getRestaurantId().equals(restaurant.getRestaurantId())).collect(Collectors.toList());
        boolean found=false;
        for(int i=0;i<restaurantList.size();i++)
        {
            if(restaurantList.get(i).getRestaurantId().equals(restaurant.getRestaurantId())){
                found=true;
            }
        }
        if(!found) {
            restaurantList.add(restaurant);
        }
            favourite.setRestaurantList(restaurantList);
            user.setFavourite(favourite);
            userRepository.save(user);
        return favourite;
    }

    @Override
    public List<Restaurant> getAllFavourite(String userId) {
        if(userRepository.findById(userId).isEmpty())
            System.out.println("not found");
        User user =  userRepository.findById(userId).get();
        Favourite favourite = user.getFavourite();

        if(favourite == null)
            favourite = new Favourite();
        List<Restaurant> restaurantList = favourite.getRestaurantList();
        if(restaurantList==null)
            restaurantList=new ArrayList<>();
        return restaurantList;
    }

    @Override
    public User removeRestaurantFavourite(String restaurantId, String userId) {
        if(userRepository.findById(userId).isEmpty())
            System.out.println("not found");
        User user =  userRepository.findById(userId).get();
        Favourite favourite = user.getFavourite();


        if(favourite == null)
            favourite = new Favourite();
        List<Restaurant> restaurantList = favourite.getRestaurantList();
        if(restaurantList==null)
            restaurantList=new ArrayList<>();

        System.out.println("hello   : "+restaurantList);
        List<Restaurant> restaurantList1 =new ArrayList<>();
        for(int i=0;i<restaurantList.size();i++){
            if(!restaurantList.get(i).getRestaurantId().equals(restaurantId)){
                restaurantList1.add(restaurantList.get(i));}
            else{
                System.out.println("dsfgfd");
                }



        }

        //List<Restaurant> restaurantList1=restaurantList.stream().filter(data->data.getRestaurantId().equals(restaurantId)).collect(Collectors.toList());
        //System.out.println("hello   : "+restaurantList1);
        //restaurantList.remove(restaurantList1.get(0));
        favourite.setRestaurantList(restaurantList1);
        user.setFavourite(favourite);
        return userRepository.save(user);
    }

//    @Override
//    public Favourite addRestaurantFavourite(String restaurantId, String userId) {
//        if(userRepository.findById(userId).isEmpty())
//            System.out.println("not found");
//        User user =  userRepository.findById(userId).get();
//        Favourite favourite = user.getFavourite();
//        List<String> restaurantList = favourite.getRestaurantList();
//        if(restaurantList==null)
//            restaurantList=new ArrayList<>();
//        restaurantList.add(restaurantId);
//        favourite.setRestaurantList(restaurantList);
//        user.setFavourite(favourite);
//        userRepository.save(user);
//        return favourite;
//    }

//    @Override
//    public Favourite deleteRestaurant(String restaurantId, String userId)
//    {
//        if(userRepository.findById(restaurantId).isEmpty())
//            System.out.println("not found");
//        User user =  userRepository.findById(restaurantId).get();
//        Favourite favourite = user.getFavourite();
//        List<String> favList = favourite.getRestaurantIds();
//        if(favList==null)
//            favList = new ArrayList<>();
////        List<String> newFavList = favList.stream().filter(data->data.equals(restaurantId)).collect(Collectors.toList());
//        List<String> newFavList = new ArrayList<>();
//        for(int i=0;i< favList.size();i++)
//        {
//            if(favList.get(i) != restaurantId){
//                newFavList.add(favList.get(i));
//            }
//        }
//        favourite.setRestaurantIds(newFavList);
//        user.setFavourite(favourite);
//        userRepository.save(user);
//        return favourite;
//
//    }
}
