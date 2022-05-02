package com.stackroute.VendorService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Vendor Already Exist! Please Login")
public class VendorAlreadyExistException extends Exception{
}
