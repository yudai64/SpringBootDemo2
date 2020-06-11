package com.example.springbootdemo2.login.domain.service;

import java.util.List;

import com.example.springbootdemo2.login.domain.model.User;
import com.example.springbootdemo2.login.domain.repository.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  
  @Autowired
  UserDao userDao;

  public int count() {
    return userDao.count();
  }

  public boolean insert(User user) {

    int rowNumber = userDao.insertOne(user);

    boolean result = false;

    if (rowNumber > 0) {
      result = true;
    }

    return result;
  }

  public List<User> selectMany() {

    return userDao.selectMany();
  }
}