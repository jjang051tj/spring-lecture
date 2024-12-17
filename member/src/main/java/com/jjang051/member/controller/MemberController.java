package com.jjang051.member.controller;

import com.jjang051.member.dto.MemberDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
    @GetMapping("/member/signup")
    public String signup() {
        return "member/signup";
    }

    @PostMapping("/member/signup")
    @ResponseBody
    public String signup(@ModelAttribute MemberDto memberDto) {
        System.out.println(memberDto.toString());
        return "member/signup";
    }

}
