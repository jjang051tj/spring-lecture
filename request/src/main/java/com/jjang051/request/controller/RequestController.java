package com.jjang051.request.controller;

import com.jjang051.request.dto.Member;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RequestController {
    @GetMapping("/request01")
    @ResponseBody
    public String request01(HttpServletRequest request) {
        //template + request01 + .html
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        return "userId : " + userId + " userPw : " + userPw;
    }

    @GetMapping("/request02")
    @ResponseBody
    public String request01(
            @RequestParam(name = "userId", required = true, defaultValue = "") String userId,
            @RequestParam(name = "userPw", required = true, defaultValue = "") String userPw
    ) {
        return "userId : " + userId + " userPw : " + userPw;
    }

    @GetMapping("/request03")
    @ResponseBody
    public String request03(String userId, String userPw, String userName, String tel) {
        return "userId : " + userId + " userPw : " + userPw+" userName : "+userName+" tel : "+tel;
    }
    @GetMapping("/request04")
    @ResponseBody
    public String request03(HttpServletRequest request) {
        String userId=request.getParameter("userId");
        String userPw=request.getParameter("userPw");
        String userName=request.getParameter("userName");
        String tel=request.getParameter("tel");
        return "userId : " + userId + " userPw : " + userPw+" userName : "+userName+" tel : "+tel;
    }

    @GetMapping("/request05")
    @ResponseBody
    public String request03(@ModelAttribute("member") Member member, Model model ) {
        return "userId : " + member.getUserId() + " userPw : " + member.getUserPw()+" userName : "+
                member.getUserName()+" tel : "+member.getTel();
    }

    @GetMapping("/request06")
    @ResponseBody
    public String request06(Member member ) {
        return "userId : " + member.getUserId() + " userPw : " + member.getUserPw()+" userName : "+
                member.getUserName()+" tel : "+member.getTel();
    }
    @GetMapping("/request07/{id}/{name}")
    @ResponseBody
    public String request06(@PathVariable String id,@PathVariable String name) {
        return "id: " + id + " name: " + name;
    }
}
