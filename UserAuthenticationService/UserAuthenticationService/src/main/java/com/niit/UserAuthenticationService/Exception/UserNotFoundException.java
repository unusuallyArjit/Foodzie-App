package com.niit.UserAuthenticationService.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "User Not found" )
  public class UserNotFoundException extends  Exception{
}
