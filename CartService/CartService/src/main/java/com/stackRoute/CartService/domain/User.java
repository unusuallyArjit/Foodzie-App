package com.stackRoute.CartService.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String userId;
    private String email;
    private String password;
    private String userName;
    private String userImage;
    private Location userAddress;
    private long userPhone;
    private Cart cart;
    private Favourite favourite;

}
