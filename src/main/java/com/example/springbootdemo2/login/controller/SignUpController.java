package com.example.springbootdemo2.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import com.example.springbootdemo2.login.domain.model.GroupOrder;
import com.example.springbootdemo2.login.domain.model.SignupForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
  
  private Map<String, String> radioMarriage;

  private Map<String, String> initRadioMarriage() {

    Map<String, String> radio = new LinkedHashMap<>();
    
    radio.put("既婚", "true");
    radio.put("未婚", "false");

    return radio;
  }

  @GetMapping("/signup")
  public String getSignUp(SignupForm signupForm, Model model) {
    
    radioMarriage = initRadioMarriage();

    model.addAttribute("radioMarriage", radioMarriage);

    return "login/signup";
  }

  @PostMapping("/signup")
  public String postSignUp(@Validated(GroupOrder.class) SignupForm signupForm, BindingResult result, Model model) {

    System.out.println(result.hasErrors());
    
    if(result.hasErrors()) {

      System.out.println("通過");
      return getSignUp(signupForm, model);
    }

      System.out.println(signupForm);

      return "redirect:/login";
  }
}