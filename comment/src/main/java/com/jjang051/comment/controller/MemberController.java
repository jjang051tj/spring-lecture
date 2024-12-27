package com.jjang051.comment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jjang051.comment.dto.MemberDto;
import com.jjang051.comment.service.MemberService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;
  private String prefix = "/member";
  
  @GetMapping("/signin")
  public String signin() {
      return prefix+"/signin";
  }


  @PostMapping("/signin")
  public String signin(@ModelAttribute MemberDto memberDto) {
      memberService.signIn(memberDto);
      return "redirect:/member/login";
  }
  

  @GetMapping("/login")
  public String login(Model model) {
      //model.addAttribute("memberDto", new MemberDto());
      return prefix+"/login";
  }

  // @PostMapping("/login")
  // public String login() {
  //     return prefix+"/login";
  // }
    
}
