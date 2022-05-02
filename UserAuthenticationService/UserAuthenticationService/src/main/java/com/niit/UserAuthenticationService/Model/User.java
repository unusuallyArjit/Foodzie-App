package com.niit.UserAuthenticationService.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor@AllArgsConstructor
public class User {


  @Id
  private String email;
  private String password;
  private String userName;


}
