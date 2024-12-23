package org.example.gallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/index/index")
    public String index() {
        return "index/index";
    }
}
