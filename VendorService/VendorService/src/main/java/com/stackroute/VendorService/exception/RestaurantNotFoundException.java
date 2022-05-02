package com.stackroute.VendorService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "No Restaurant Exist please add")
public class RestaurantNotFoundException extends Exception{
}
