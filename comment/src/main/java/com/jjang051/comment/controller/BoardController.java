package com.jjang051.comment.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjang051.comment.entity.Board;
import com.jjang051.comment.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("/board")
@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {
  private final BoardService boardService;
  private String prefix = "/board";

  @GetMapping("/write")
  public String write() {
      return prefix+"/write";
  }

  @PostMapping("/write")
  public String write(@RequestParam(name = "title") String title,@RequestParam(name = "content") String content) {
      boardService.write(title,content);
      return "redirect:/board/list";
  }

  @GetMapping("/list")
  public String getList(Model model) {

    List<Board> boardList = boardService.getList();
    model.addAttribute("boardList", boardList);
    return prefix+"/list";
  }

  @GetMapping("/view/{id}")
  public String getView(@PathVariable("id") Long id,Model model) {
      Board board= boardService.getView(id);
      log.info("commentList==={}",board.getCommentList().size());
      model.addAttribute("board", board);
      return prefix+"/view";
  }
  
  
}
