package com.example.springbootdemo2.login.domain.repository.jdbc;

import java.util.List;

import com.example.springbootdemo2.login.domain.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("UserDaoJdbcImpl3")
public class UserDaoJdbcImpl3 extends UserDaoJdbcImpl{
  
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public User selectOne(String userId) {

    String sql = "SELECT * FROM m_user WHERE user_id=?";

    RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);

    return jdbcTemplate.queryForObject(sql, rowMapper, userId);
  }

  @Override
  public List<User> selectMany() {

    String sql = "SELECT * FROM m_user";

    RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);

    return jdbcTemplate.query(sql, rowMapper);
  }
}