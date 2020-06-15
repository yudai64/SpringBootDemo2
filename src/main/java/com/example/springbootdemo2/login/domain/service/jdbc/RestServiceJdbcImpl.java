package com.example.springbootdemo2.login.domain.service.jdbc;

import java.util.List;

import com.example.springbootdemo2.login.domain.model.User;
import com.example.springbootdemo2.login.domain.repository.UserDao;
import com.example.springbootdemo2.login.domain.service.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class RestServiceJdbcImpl implements RestService{

  @Autowired
  @Qualifier("UserDaoJdbcImpl")
  UserDao userDao;
  
  @Override
  public boolean insert(User user) {
    return false;
  };

  @Override
  public User selectOne(String userId) {
    return null;
  };

  @Override
  public List<User> selectMany() {
    return null;
  };

  @Override
  public boolean update(User user) {
    return false;
  };

  @Override
  public boolean delete(String userId) {
    return false;
  };
}