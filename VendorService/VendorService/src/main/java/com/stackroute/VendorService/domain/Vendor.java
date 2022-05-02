package com.stackroute.VendorService.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {

    @Id
    private String vendorId;
    private String vendorEmail;
    private String vendorName;
    private long vendorPhone;
    private String vendorImage;
    private Location vendorAddress;
    private String restaurantId;

}
