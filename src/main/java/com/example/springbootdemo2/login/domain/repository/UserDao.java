package com.example.springbootdemo2.login.domain.repository;

import com.example.springbootdemo2.login.domain.model.User;

import org.springframework.dao.DataAccessException;

public interface UserDao {
  
  public int count() throws DataAccessException;


  // Userテーブルにデータを一件挿入
  public int insertOne(User user) throws DataAccessException;

  //Userテーブルのデータを一件取得
  public int selectOne(String userId) throws DataAccessException;


    //Userテーブルのデータを全件取得
    public int selectMany() throws DataAccessException;

  //Userテーブルのデータを一件更新
  public int updateOne(User user) throws DataAccessException;

  //Userテーブルのデータを一件削除
  public int deleteOne(String userId) throws DataAccessException;

  //SQL取得結果をサーバーにCSVで保存する
  public void userCsvOut() throws DataAccessException;
}