package com.niit.UserAuthenticationService.Service;


import com.niit.UserAuthenticationService.Model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceTokenGeneratorImpli implements ServiceTokenGenerator{


  @Override
  public Map<String, String> generateToken(User user) {

    String JwtToken = null;

    JwtToken = Jwts.builder().setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"secretKey")
                .compact();
    Map<String,String> map = new HashMap<>();
    map.put("token",JwtToken);
    map.put("message","Authentication Successful");
    return map;

  }
}
