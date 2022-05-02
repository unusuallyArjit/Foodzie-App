package com.niit.UserAuthenticationService.Service;

import com.niit.UserAuthenticationService.Exception.UserNotFoundException;
import com.niit.UserAuthenticationService.Model.User;
import com.niit.UserAuthenticationService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpli implements UserService {

  private UserRepository userRepository;

  @Autowired
  public UserServiceImpli(UserRepository userRepository){
    this.userRepository=userRepository;
  }



  @Override
  public User saveUser(User user) {


    return userRepository.save(user);
  }

  @Override
  public User findByEmailAndPassword(String email, String password) throws UserNotFoundException {

    User user = userRepository.findByEmailAndPassword(email, password);


    if(user == null)
    {
      throw new UserNotFoundException();
    }

    return user;
  }

  @Override
  public List<User> getAllUser() {
    return userRepository.findAll();
  }
}
