package com.jjang051.comment.controller;

import javax.swing.border.Border;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjang051.comment.entity.Board;
import com.jjang051.comment.service.BoardService;
import com.jjang051.comment.service.CommentService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")

public class CommentController {

  private final CommentService commentService;
  private final BoardService boardService;


  @PostMapping("/write/{id}")
  @ResponseBody
  public String write(@PathVariable("id") Long id, @RequestParam(name = "content") String content) {
    Board board = boardService.getView(id);
    commentService.write(content,board);
    return "comment";
  }
}
