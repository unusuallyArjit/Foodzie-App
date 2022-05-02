package com.stackroute.VendorService.service.VendorService;

import com.stackroute.VendorService.domain.*;
import com.stackroute.VendorService.exception.*;

public interface VendorService {

    public Vendor saveVendorDetails(Vendor vendor) throws VendorAlreadyExistException;
    public Vendor editVendorDetails(Vendor vendor,String email) throws VendorNotFoundException;
    public Vendor getVendorByVendorEmail(String email);








}
