package com.stackRoute.CartService.service;

import com.stackRoute.CartService.domain.User;
import com.stackRoute.CartService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public User getUserByEmail(String email) {



        return  userRepository.getUserByEmail(email);
    }
}
