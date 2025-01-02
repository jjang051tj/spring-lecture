package com.jjang051.comment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jjang051.comment.dto.EmailDto;
import com.jjang051.comment.service.MailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/mail")
@RequiredArgsConstructor
@Slf4j
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

  @PostMapping("/confirm")
  @ResponseBody
  public Map<String, String> confirm(@RequestBody EmailDto emailDto) {
    String randomNumber = mailService.sendAuthMail(emailDto.getEmail());
    Map<String,String> resultMap = new HashMap<>();
    resultMap.put("confirmNumber", randomNumber);
    return resultMap;
  }
}
