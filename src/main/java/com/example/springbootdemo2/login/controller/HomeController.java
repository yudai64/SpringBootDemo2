package com.example.springbootdemo2.login.controller;

import java.util.List;

import com.example.springbootdemo2.login.domain.model.User;
import com.example.springbootdemo2.login.domain.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
  
  @Autowired
  UserService userService;

  @GetMapping("/home")
  public String getHome(Model model) {

    model.addAttribute("contents", "login/home::home_contents");

    return "login/homeLayout.html";
  }

  @GetMapping("/userList")
  public String getUserList(Model model) {

    model.addAttribute("contents", "login/userList :: userList_contents");

    List<User> userList = userService.selectMany();

    model.addAttribute("userList", userList);

    int count = userService.count();
    model.addAttribute("userListCount", count);

    return "login/homeLayout";
  }

  @PostMapping("/logout")
  public String postLogout() {

    return "redirect:/login";
  }

  //未実装
  @GetMapping("/userList/csv")
  public String getUserListCsv(Model model) {

    return getUserList(model);
  }
}