package com.jjang.jpa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjang.jpa.entity.Question;
import com.jjang.jpa.service.QuestionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
@Slf4j
public class QuestionController {

  private final QuestionService questionService;

  @GetMapping("/write")
  public String write() {
      return "/question/write";  
  }
  @PostMapping("/write")
  public String write(@RequestParam("title") String title,@RequestParam("content") String content) {
      log.info("title==={},content==={}",title,content);
      questionService.write(title, content);
      return "redirect:/";  
  }

  @GetMapping("/list")
  //@ResponseBody
  public String getList(Model model) {
    List<Question> questionList = questionService.getList();
    model.addAttribute("questionList", questionList);
    return "/question/list";
  }
}
