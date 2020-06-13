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

  public User selectOne(String userId) {

    return userDao.selectOne(userId);
  }

  public List<User> selectMany() {

    return userDao.selectMany();
  }

  public boolean updateOne(User user) {

    int rowNumber = userDao.updateOne(user);

    boolean result = false;

    if(rowNumber > 0) {
      result= true;
    }

    return result;

  }

  public boolean deleteOne(String userId) {

    int rowNumber = userDao.deleteOne(userId);

    boolean result = false;

    if(rowNumber > 0) {
      result = true;
    }

    return result;
  }
}