package com.jjang051.member.controller;

import com.jjang051.member.dto.MemberDto;
import com.jjang051.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//Bean으로 등록
@RequestMapping("/member")
@Controller
@RequiredArgsConstructor
public class MemberController {

    //MemberService memberService = new MemberService();

//    @Autowired
//    private MemberService memberService;

    private final MemberService memberService; //불변성 유지
    
//    @RequiredArgsConstructor  //이 롬복 annotation이 final이 붙어있는 속성을 찾아서 생성자 매개변수 형태로 생성자 만들어줌
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }

    @GetMapping("/signup")
    public String signup() {
        return "member/signup";
    }

    @PostMapping("/signup")
    //@ResponseBody
    public String signup(@ModelAttribute MemberDto memberDto) {
        //System.out.println(memberDto.toString());
        int result = memberService.signup(memberDto);
        System.out.println("result : " + result);
        if(result>0) {
            return "redirect:/index/index";
        }
        return "/member/signup";
    }
    @GetMapping("/login")
    public String login() {
        return "/member/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
        MemberDto loggedMemberDto =  memberService.login(memberDto);
        if(loggedMemberDto!=null) {
            session.setAttribute("loggedMemberDto", loggedMemberDto);
        }
        System.out.println("loggedMemberDto : " + loggedMemberDto.toString());
        return "redirect:/index/index";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loggedMemberDto");
        session.invalidate();
        return "redirect:/index/index";
    }

}
