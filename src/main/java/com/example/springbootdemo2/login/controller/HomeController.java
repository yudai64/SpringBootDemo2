package com.example.springbootdemo2.login.controller;

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

  @PostMapping("/logout")
  public String postLogout() {

    return "redirect:/login";
  }
}