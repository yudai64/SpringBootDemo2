package com.example.springbootdemo2.login.domain.service;

import com.example.springbootdemo2.login.domain.repository.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  
  @Autowired
  UserDao userDao;
}