package com.jjang051.comment.controller;

import java.util.HashMap;
import java.util.Map;

import javax.swing.border.Border;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjang051.comment.entity.Board;
import com.jjang051.comment.entity.Comment;
import com.jjang051.comment.service.BoardService;
import com.jjang051.comment.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
@Slf4j
public class CommentController {

  private final CommentService commentService;
  private final BoardService boardService;


  @PostMapping("/write/{id}")
  public String write(@PathVariable("id") Long id, @RequestParam(name = "content") String content) {
    Board board = boardService.getView(id);
    commentService.write(content,board);
    return "redirect:/board/view/"+id;
  }


  @PostMapping("/write-ajax/{id}")
  @ResponseBody
  public Map<String, Object> writeAjax(@PathVariable("id") Long id, @RequestBody Comment comment) {
    log.info("comment==={}",comment.getContent());
    Board board = boardService.getView(id);
    Comment insertComment = commentService.write(comment.getContent(),board);
    Map<String, Object> resultMap =  new HashMap<>();
    resultMap.put("isInsert", "ok");
    resultMap.put("insertComment", insertComment);
    return resultMap;
  }
  
  
  //get, post, delete, patch, put
  @DeleteMapping("/delete/{id}")
  @ResponseBody
  public Map<String,String> dlete(@PathVariable("id") Long id) {
      log.info("id==={}",id);
      commentService.delete(id);
      Map<String, String> resultMap =  new HashMap<>();
      resultMap.put("isDelete", "ok");
      return resultMap;
  }
  
}
