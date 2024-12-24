package com.jjang051.comment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/board")
@Controller
public class BoardController {

  //private String prefix = "/board"

  @GetMapping("/write")
  public String write() {
      return "/board/write";
  }
}
