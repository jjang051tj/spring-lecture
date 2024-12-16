package com.jjang051.ch01.controller;

import com.jjang051.ch01.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController {


    // DI (dependency injection)  의존성 주입

    @Autowired
    MemberService memberService;

    @GetMapping("/list")
    public String list(@RequestParam(value = "userId", required = true, defaultValue = "0") String userId,
                       @RequestParam(value = "userPw", required = true, defaultValue = "1234") String userPw,
                       Model model) {
        model.addAttribute("title","Member List");
        System.out.println("userId : "+userId);
        System.out.println("userPw : "+userPw);
        return "member/list";
    }

    @GetMapping("/list02")
    public String list02(String userId, Model model) {
        model.addAttribute("title","Member List");
        System.out.println("userId : "+userId);
        return "member/list";
    }
    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("title","Sign UP");
        return "member/signup";
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title","Login");
        return "member/login";
    }
    @PostMapping("/login")
    public String login(Model model,
                        @RequestParam(value = "userId", required = true) String userId,
                        @RequestParam(value = "userPw", required = true) String userPw) {
//        if(userId.equals("jjang051") && userPw.equals("1234")) {
//            return "redirect:/index/index";
//        }
        //MemberService memberService = new MemberService();
        //강한결합 약한 결합
        boolean isLogin = memberService.login(userId, userPw);
        if(isLogin) {
            return "redirect:/index/index";
        }
        model.addAttribute("title","Login");
        return "member/login";
    }

    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("title","All");
        return "member/all";
    }

    @GetMapping("/delete")
    public ModelAndView delete() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("title","Member Delete");
        mv.setViewName("member/delete");
        return mv;
    }


}
