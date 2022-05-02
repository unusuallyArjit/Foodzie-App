package com.niit.UserAuthenticationService.Service;

import com.niit.UserAuthenticationService.Model.User;

import java.util.Map;

public interface ServiceTokenGenerator {

  Map<String,String> generateToken(User user);
}
