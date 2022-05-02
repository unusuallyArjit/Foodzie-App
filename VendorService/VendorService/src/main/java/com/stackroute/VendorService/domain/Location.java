package com.stackroute.VendorService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    private String street;
    private String landmark;
    private String state;
    private String city;
    private int zipcode;
    private int locLat;
    private int LocLong;
}
