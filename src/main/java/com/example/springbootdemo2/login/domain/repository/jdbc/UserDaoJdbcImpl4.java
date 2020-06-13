package com.example.springbootdemo2.login.domain.repository.jdbc;

import java.util.List;

import com.example.springbootdemo2.login.domain.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("UserDaoJdbcImpl4")
public class UserDaoJdbcImpl4 extends UserDaoJdbcImpl{
  
  @Autowired
  JdbcTemplate jdbcTemplate;

  public List<User> selectMany() {

    String sql = "SELECT * FROM m_user";

    UserResultSetExtractor extractor = new UserResultSetExtractor();

    return jdbcTemplate.query(sql, extractor);
  }
}