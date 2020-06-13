package com.example.springbootdemo2.login.domain.repository.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.example.springbootdemo2.login.domain.model.User;
import com.example.springbootdemo2.login.domain.repository.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("UserDaoJdbcImpl")
public class UserDaoJdbcImpl implements UserDao{
  
  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public int count() throws DataAccessException {

    int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM m_user", Integer.class);
    return count;
  }

  // Userテーブルにデータを一件挿入
  @Override
  public int insertOne(User user) throws DataAccessException {

    int rowNumber = jdbcTemplate.update("INSERT INTO m_user(user_id, password, user_name, birthday, age, marriage, role) VALUES(?, ?, ?, ?, ?, ?, ?)"
                                                    ,user.getUserId(), user.getPassword(), user.getUserName(), user.getBirthday(), user.getAge(), user.isMarriage(), user.getRole());
    return rowNumber;
  }

  //Userテーブルのデータを一件取得
  @Override
  public User selectOne(String userId) throws DataAccessException {

    Map<String, Object> map = jdbcTemplate.queryForMap("SELECT * FROM m_user WHERE user_id = ?", userId);

    User user = new User();

    user.setUserId((String)map.get("user_id"));
    user.setPassword((String)map.get("password"));
    user.setUserName((String)map.get("user_name"));
    user.setBirthday((Date)map.get("birthday"));
    user.setAge((Integer)map.get("age"));
    user.setMarriage((Boolean)map.get("marriage"));
    user.setRole((String)map.get("role"));
    
    return user;
  }


    //Userテーブルのデータを全件取得
    @Override
    public List<User> selectMany() throws DataAccessException {

      //テーブルから全件所得
      List<Map<String, Object>> getList = jdbcTemplate.queryForList("SELECT * FROM m_user");

      //結果返却用の変数
      List<User> userList = new ArrayList<>();

      //所得したデータを結果返却用のListに格納していく
      for(Map<String, Object> map: getList) {

        User user = new User();

        user.setUserId((String)map.get("user_id"));
        user.setPassword((String)map.get("password"));
        user.setUserName((String)map.get("user_name"));
        user.setBirthday((Date)map.get("birthday"));
        user.setAge((Integer)map.get("age"));
        user.setMarriage((Boolean)map.get("marriage"));
        user.setRole((String)map.get("role"));
        
        userList.add(user);
      }

      return userList;
    }

  //Userテーブルのデータを一件更新
  @Override
  public int updateOne(User user) throws DataAccessException {

    int rawNumber = jdbcTemplate.update("UPDATE m_user SET password = ?, user_name = ?, birthday = ?, age = ?, marriage = ? WHERE user_id = ?",
                                                                user.getPassword(), user.getUserName(), user.getBirthday(), user.getAge(), user.isMarriage(), user.getUserId());
    return rawNumber;
  }

  //Userテーブルのデータを一件削除
  @Override
  public int deleteOne(String userId) throws DataAccessException {

    int rowNumber = jdbcTemplate.update("DELETE FROM m_user WHERE user_id = ?", userId);

    return rowNumber;
  }

  //SQL取得結果をサーバーにCSVで保存する
  @Override
  public void userCsvOut() throws DataAccessException {

    String sql = "SELECT * FROM m_user";

    UserRowCallbackHandler handler = new UserRowCallbackHandler();

    jdbcTemplate.query(sql, handler);
  }

}