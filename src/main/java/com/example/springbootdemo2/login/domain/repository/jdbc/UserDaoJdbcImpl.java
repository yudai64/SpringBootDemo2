package com.example.springbootdemo2.login.domain.repository.jdbc;

import java.util.List;

import com.example.springbootdemo2.login.domain.model.User;
import com.example.springbootdemo2.login.domain.repository.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoJdbcImpl implements UserDao{
  
  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public int count() throws DataAccessException {
    return 0;
  }

  // Userテーブルにデータを一件挿入
  @Override
  public int insertOne(User user) throws DataAccessException {
    return 0;
  }

  //Userテーブルのデータを一件取得
  @Override
  public User selectOne(String userId) throws DataAccessException {
    return null;
  }


    //Userテーブルのデータを全件取得
    @Override
    public List<User> selectMany() throws DataAccessException {
      return null;
    }

  //Userテーブルのデータを一件更新
  @Override
  public int updateOne(User user) throws DataAccessException {
    return 0;
  }

  //Userテーブルのデータを一件削除
  @Override
  public int deleteOne(String userId) throws DataAccessException {
    return 0;
  }

  //SQL取得結果をサーバーにCSVで保存する
  @Override
  public void userCsvOut() throws DataAccessException {

  }

}