package com.stackroute.VendorService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Vendor Email does not Exist! Please Register")
public class VendorNotFoundException extends Exception{
}
