package com.jjang051.comment.controller;


import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jjang051.comment.dto.CustomUserDetails;
import com.jjang051.comment.dto.MemberDto;
import com.jjang051.comment.entity.Board;
import com.jjang051.comment.entity.Member;
import com.jjang051.comment.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

  private final MemberService memberService;
  private String prefix = "/member";
  
  @GetMapping("/signin")
  public String signin() {
      return prefix+"/signin";
  }


  @PostMapping("/signin")
  public String signin(@Valid @ModelAttribute MemberDto memberDto) {
      memberService.signIn(memberDto);
      return "redirect:/member/login";
  }
  

  @GetMapping("/login")
  public String login(Model model) {
      //model.addAttribute("memberDto", new MemberDto());
      return prefix+"/login";
  }

  @GetMapping("/info")
  public String info() {
      return prefix+"/info";
  }
  @GetMapping("/modify")
  public String modify() {
    return prefix+"/modify";
  }

  @PostMapping("/modify")
  public String modify(@ModelAttribute MemberDto memberDto) {
    Member modifiedMember = memberService.modify(memberDto);
    if(modifiedMember!=null) {
        return "redirect:/";
    }
    return prefix+"/modify";
  }

  @GetMapping("/board")
  public String board(Model model,@AuthenticationPrincipal CustomUserDetails customUserDetails) {
    List<Board> boardList= memberService.findAllBoards(customUserDetails.getLoggedMember().getUserId());
    log.info("boardList==={}",boardList.get(0));
    log.info("boardList==={}",boardList.get(1));
    log.info("boardList==={}",boardList.get(2));
    
    model.addAttribute("boardList", boardList);
    return prefix+"/board";
  }

  

  // @PostMapping("/login")
  // public String login() {
  //     return prefix+"/login";
  // }
    
}
