package com.jjang051.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/member/signup")
    public String signup() {
        return "member/signup";
    }
}
