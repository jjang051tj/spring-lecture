package com.dydqja5750.gallery.controller;

import com.dydqja5750.gallery.dto.GalleryDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
    @GetMapping("/write")
    public String write(Model model) {
        List<Map<String,String>> selectList=new ArrayList<>();
        Map<String,String> map=new HashMap<>();
        map.put("paint","PAINT");
        map.put("photo","PHOTO");
        map.put("sketch","SKETCH");
        selectList.add(map);
        model.addAttribute("galleryDto", new GalleryDto());
        model.addAttribute("galleryDto", new GalleryDto());
        return "gallery/write";
    }
}
