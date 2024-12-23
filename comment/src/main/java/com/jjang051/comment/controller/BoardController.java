package com.jjang051.comment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjang051.comment.service.BoardService;

import lombok.RequiredArgsConstructor;


@RequestMapping("/board")
@Controller
@RequiredArgsConstructor
public class BoardController {
  private final BoardService boardService;
  private String prefix = "/board";

  @GetMapping("/write")
  public String write() {
      return prefix+"/write";
  }

  @PostMapping("/write")
  @ResponseBody
  public String write(@RequestParam(name = "title") String title,@RequestParam(name = "content") String content) {
      boardService.write(title,content);
      return prefix+"/list";
  }
}
