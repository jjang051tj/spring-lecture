package com.jjang051.comment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjang051.comment.service.CommentService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")

public class CommentController {

  private final CommentService commentService;


  @PostMapping("/write/{id}")
  @ResponseBody
  public String write(@PathVariable("id") Long id, @RequestParam(name = "content") String content) {
    commentService.write(content,id);
    return "comment";
  }
}
