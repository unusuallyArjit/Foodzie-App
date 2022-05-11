package com.stackRoute.CartService.service;

import com.stackRoute.CartService.domain.Cart;
import com.stackRoute.CartService.domain.CartItem;
import com.stackRoute.CartService.domain.Dish;
import com.stackRoute.CartService.domain.User;
import com.stackRoute.CartService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    public UserRepository userRepository;


    @Override
    public User addUser(User user) {

        user.setUserId(UUID.randomUUID().toString());


        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user,String userId) {
        if(userRepository.findById(userId).isEmpty())
            System.out.println("Error");
        return userRepository.save(user);
    }

    @Override
    public User addDishToCart(CartItem item, String userId) {

        User user = userRepository.findById(userId).get();

        Cart currentCart = user.getCart();

        if(currentCart == null){
            currentCart = new Cart();
            currentCart.setCartId(UUID.randomUUID().toString());

        }



        List<CartItem> currentCartItemList = currentCart.getCartItemList();

        if(currentCartItemList == null)
            currentCartItemList = new ArrayList<CartItem>();

        boolean found = false;
        for(int i = 0;i < currentCartItemList.size();i++){

            if(currentCartItemList.get(i).getDish().getDishId().equals(item.getDish().getDishId())){
                currentCartItemList.get(i).setDishQuantity(currentCartItemList.get(i).getDishQuantity() + item.getDishQuantity());
                found = true;
            }
        }
        if(!found){

            currentCartItemList.add(item);
        }

        currentCart.setCartItemList(currentCartItemList);
        user.setCart(currentCart);
        return userRepository.save(user);



    }

    @Override

    public  List<CartItem> getCartDetails(String userId){

        User user = userRepository.findById(userId).get();
        Cart cart = user.getCart();
        List<CartItem> cartItemList = cart.getCartItemList();
        if(cartItemList == null)
            cartItemList = new ArrayList<>();
        return cartItemList;
    }

    @Override
    public CartItem increaseCartItemQuantity(Dish dish, String user) {
        return null;
    }

    @Override
    public CartItem decreaseCartItemQuantity(Dish dish, String user) {
        return null;
    }

    @Override
    public CartItem deleteCartItem(Dish dish, String user) {
        return null;
    }

    @Override
    public double getTotalCartAmount(Cart cart, String userId) {
        String CartId = cart.getCartId();
        List<CartItem>cartItemList = cart.getCartItemList();
        double amount =0;
        for(CartItem cartItem : cartItemList)
        {
            Dish dish = cartItem.getDish();
            List<Integer> dishPrices = dish.getDishPrice();
            double dishAmount = 0;
            for(Integer dishprice : dishPrices)
            {
                dishAmount = dishAmount + dishprice;
            }
            int dishQuantity = cartItem.getDishQuantity();
            amount =  amount + dishAmount*dishQuantity;
        }
        return amount;
    }

    @Override
    public Cart addDishToCartItem(Dish dish, String userId, int quantity) {
        User user = userRepository.findById(userId).get();
        Cart cart = user.getCart();

        if(cart==null) {
            cart = new Cart();
            List<CartItem> cartItemList = new ArrayList<>();
            CartItem cartItem = new CartItem();
            cartItem.setDish(dish);
            cartItem.setDishQuantity(quantity);
            cartItemList.add(cartItem);
            cart.setCartItemList(cartItemList);
            user.setCart(cart);
            userRepository.save(user);
        }
        else {
            List<CartItem> cartItemList = cart.getCartItemList();
            if (cartItemList == null)
                cartItemList = new ArrayList<>();
            CartItem cartItem = new CartItem();
            cartItem.setDish(dish);
            cartItem.setDishQuantity(quantity);
            cartItemList.add(cartItem);
            cart.setCartItemList(cartItemList);
            user.setCart(cart);
            userRepository.save(user);
        }
        return cart;
    }

    @Override
    public User emptyCart(String userId) {
        User user = userRepository.findById(userId).get();
        Cart cart = user.getCart();
        if(cart == null)
            cart = new Cart();
        List<CartItem> cartItemList = cart.getCartItemList();
        if(cartItemList == null)
            cartItemList = new ArrayList<>();
        cartItemList.clear();
        cart.setCartItemList(cartItemList);
        user.setCart(cart);
        userRepository.save(user);
        return user;
    }
}
