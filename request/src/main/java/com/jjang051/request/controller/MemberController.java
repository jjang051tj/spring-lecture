package com.jjang051.request.controller;

import com.jjang051.request.dto.Member;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @GetMapping("/member/login")
    public String login(Model model) {
        model.addAttribute("member", new Member());
        return "member/login";
    }

    /*
    @PostMapping("/member/login")
    public String login(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        if(userId.equals("jjang051") && userPw.equals("1234")) {
            return "redirect:/index/index";
        }
        return "member/login";
    }
     */
    /*
    @PostMapping("/member/login")
    public String login(@RequestParam String userId, @RequestParam String userPw) {
        if(userId.equals("jjang051") && userPw.equals("1234")) {
            return "redirect:/index/index";
        }
        return "member/login";
    }
     */
    @PostMapping("/member/login")
    public String login(@ModelAttribute Member member) {
        if(member.getUserId().equals("jjang051") && member.getUserPw().equals("1234")) {
            return "redirect:/index/index";
        }
        return "member/login";
    }




    @GetMapping("/index/index")
    public String index() {
        return "index/index";
    }
}
