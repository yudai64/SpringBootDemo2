package com.example.springbootdemo2.login.domain.service;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.example.springbootdemo2.login.domain.model.User;
import com.example.springbootdemo2.login.domain.repository.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {
  
  @Autowired
  @Qualifier("UserDaoJdbcImpl")
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

  //ユーザー一覧をCSVで出力する
  public void userCsvOut() throws DataAccessException {
    userDao.userCsvOut();
  }

  //サーバーに保存されているファイルを取得して、byte配列に変換する
  public byte[] getFile(String fileName) throws IOException {

    //ファイルシステム(デフォルト)の取得
    FileSystem fs = FileSystems.getDefault();

    Path p = fs.getPath(fileName);

    //ファイルをbyte配列に変換
    byte[] bytes = Files.readAllBytes(p);

    return bytes;
  }
}