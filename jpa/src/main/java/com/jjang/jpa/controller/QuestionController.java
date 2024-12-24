package com.jjang.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/question")
public class QuestionController {

  @GetMapping("/write")
  public String write() {
      return "/question/write";  
  }
}
