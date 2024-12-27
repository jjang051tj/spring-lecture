package com.jjang051.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjang051.review.service.ReviewService;

import lombok.RequiredArgsConstructor;


@RequestMapping("/review")
@Controller
@RequiredArgsConstructor
public class ReivewController {

  private final ReviewService reviewService;

  @GetMapping("/write")
  public String write() {
      return "/review/write";
  }


  @PostMapping("/write")
  public String write(@RequestParam(name = "title") String title,
                      @RequestParam(name = "content") String content) {
      reviewService.write(title,content);                          
      return "redirect:/review/write";
  }
}
