package com.stackroute.VendorService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Dish with this name does not exist please add it first")
public class DishNotFoundException extends Exception{
}
