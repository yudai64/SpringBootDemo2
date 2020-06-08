package com.example.springbootdemo2.tryspring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class HelloController {

  @Autowired
  private HelloService helloService;
  
  @GetMapping("/hello")
  public String getHello() {

    return "hello";
  }

  @PostMapping("/hello")
  public String postRequest(@RequestParam("text1")String str, Model model) {

    model.addAttribute("sample", str);
    return "helloRequest";
  }

  @PostMapping("/hello/db")
  public String postDbRequest(@RequestParam("text2")String str, Model model) {

    int id = Integer.parseInt(str);
    Employee employee = helloService.findOne(id);

    model.addAttribute("id", employee.getEmployee_id());
    model.addAttribute("name", employee.getEmployee_name());
    model.addAttribute("age", employee.getAge());

    return "helloResponseDB";
  }
  
}