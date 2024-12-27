package com.jjang051.comment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/member")
public class MemberController {

  private String prefix = "/member";
  @GetMapping("/signin")
  public String signin() {
      return prefix+"/signin";
  }

  @GetMapping("/login")
  public String login(Model model) {
      model.addAttribute("memberDto", new MemberDto());
    
      return prefix+"/login";
  }

  // @PostMapping("/login")
  // public String login() {
  //     return prefix+"/login";
  // }
    
}
