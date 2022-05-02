package com.stackRoute.CartService.service;

import com.stackRoute.CartService.domain.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserByEmail(String email);
}
