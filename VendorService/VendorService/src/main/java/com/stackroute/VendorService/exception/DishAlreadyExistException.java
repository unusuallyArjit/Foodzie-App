package com.stackroute.VendorService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Dish with this Name Already Exist in the restaurant please add with different name ")
public class DishAlreadyExistException extends Exception{
}
