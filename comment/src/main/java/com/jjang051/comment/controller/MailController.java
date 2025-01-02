package com.jjang051.comment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jjang051.comment.service.MailService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {
  private final MailService mailService;

  private String prefix = "/mail";

  @GetMapping("/find-password")
  public String findPassword() {
      return prefix+"/find-password";
  }


  @PostMapping("/find-password")
  public String findPasswordProcess(@RequestParam(name="userEmail") String userEmail) {
      mailService.sendMail(userEmail);
      return "redirect:/member/login";
  }
  
}
