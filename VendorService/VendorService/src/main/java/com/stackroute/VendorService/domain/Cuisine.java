package com.stackroute.VendorService.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuisine {


    @Id
    private String cuisineId;
    private String cuisineName;
    private List<String>cuisineImages;
    private List<String> restaurantIds;


}
