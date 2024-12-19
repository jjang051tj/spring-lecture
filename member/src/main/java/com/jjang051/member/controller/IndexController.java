package com.jjang051.member.controller;

import com.jjang051.member.dto.ModalDto;
import com.jjang051.member.dto.ToastDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @GetMapping("/index/index")
    public String index(@ModelAttribute ModalDto modalDto, @ModelAttribute ToastDto toastDto) {
        System.out.println(modalDto.toString());
        System.out.println(toastDto.toString());
        return "index/index";
    }
}
