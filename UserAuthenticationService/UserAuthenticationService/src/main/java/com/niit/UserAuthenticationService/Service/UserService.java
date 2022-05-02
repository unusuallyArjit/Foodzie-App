package com.niit.UserAuthenticationService.Service;

import com.niit.UserAuthenticationService.Exception.UserNotFoundException;
import com.niit.UserAuthenticationService.Model.User;

import java.util.List;

public interface UserService {

  public User saveUser(User user);
  public User findByEmailAndPassword(String email,String password) throws UserNotFoundException;
  public List<User> getAllUser();
}
