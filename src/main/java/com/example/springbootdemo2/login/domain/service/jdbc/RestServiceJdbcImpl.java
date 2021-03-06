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

    int result = userDao.insertOne(user);

    if(result == 0) {
      return false;
    }
    return true;
  };

  @Override
  public User selectOne(String userId) {
    return userDao.selectOne(userId);
  };

  @Override
  public List<User> selectMany() {
    return userDao.selectMany();
  };

  @Override
  public boolean update(User user) {

    int result = userDao.updateOne(user);

    if(result == 0) {
      return false;
    }
    return true;
  };

  @Override
  public boolean delete(String userId) {
    
    int result = userDao.deleteOne(userId);

    if(result == 0) {
      return false;
    }
    return true;
  };
}