package com.stackroute.VendorService.service.VendorService;

import com.stackroute.VendorService.domain.*;
import com.stackroute.VendorService.exception.*;
import com.stackroute.VendorService.repository.RestaurantRepository;
import com.stackroute.VendorService.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VendorServiceImpl implements VendorService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private VendorRepository vendorRepository;


    @Override
    public Vendor saveVendorDetails(Vendor vendor) throws VendorAlreadyExistException {
        if(vendorRepository.findById(vendor.getVendorEmail()).isPresent())
            throw new VendorAlreadyExistException();

        vendor.setVendorId(UUID.randomUUID().toString());
        return vendorRepository.save(vendor);
    }

    @Override
    public Vendor editVendorDetails(Vendor vendor, String vendorId) throws VendorNotFoundException {

        if(vendorRepository.findById(vendorId).isEmpty() || vendorId == null){
            throw  new VendorNotFoundException();
        }
        Vendor vendorCurrent = vendorRepository.findById(vendorId).get();
        vendor.setRestaurantId(vendorCurrent.getRestaurantId());
        vendor.setVendorId(vendorId);
        return vendorRepository.save(vendor);
    }

    @Override
    public Vendor getVendorByVendorEmail(String email) {

        return vendorRepository.getVendorByVendorEmail(email);
    }


}
