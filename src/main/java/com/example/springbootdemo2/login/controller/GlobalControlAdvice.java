package com.example.springbootdemo2.login.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class GlobalControlAdvice {
  
  @ExceptionHandler(DataAccessException.class)
  public String dataAccessExceptionHandler(DataAccessException e, Model model) {

    model.addAttribute("error", "内部サーバーエラー(DB): ExceptionHandler");

    model.addAttribute("message", "DataAccessExceptionが発生しました");

    model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);

    return "error";
  }

}