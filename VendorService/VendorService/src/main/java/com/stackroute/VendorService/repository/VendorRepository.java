package com.stackroute.VendorService.repository;

import com.stackroute.VendorService.domain.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends MongoRepository<Vendor,String> {

    @Query("{'vendorEmail' : ?0}")
    public Vendor getVendorByVendorEmail(String vendorEmail);
}
