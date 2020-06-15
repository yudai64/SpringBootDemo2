package com.example.springbootdemo2.login.controller;

import com.example.springbootdemo2.login.domain.service.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
  
  @Autowired
  RestService restService;
}