package com.example.springbootdemo2.login.controller;

import java.util.List;

import com.example.springbootdemo2.login.domain.model.User;
import com.example.springbootdemo2.login.domain.service.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
  
  @Autowired
  RestService restService;

  @GetMapping("/rest/get")
  public List<User> getUserMany() {
    return restService.selectMany();
  }

  @GetMapping("/rest/get/{id:.+}")
  public User getUserOne(@PathVariable("id") String userId) {
    return restService.selectOne(userId);
  }
}