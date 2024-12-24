package org.example.gallery.controller;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.gallery.dto.GalleryDto;
import org.example.gallery.service.GalleryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/gallery")
@MultipartConfig
@RequiredArgsConstructor
public class GalleryController {

    public final GalleryService galleryService;

    private void sendCategory(Model model) {
        Map<String,String> map = new HashMap<>();
        map.put("paint","Paint");
        map.put("photo","Photo");
        map.put("sketch","Sketch");
        model.addAttribute("category", map);
    }

    @GetMapping("/write")
    public String write(Model model) {
        
        model.addAttribute("galleryDto", new GalleryDto());
        sendCategory(model);
        return "gallery/write";
    }

    @PostMapping("/write")
    public String write(@Valid @ModelAttribute GalleryDto galleryDto,
                        BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            sendCategory(model); 
            System.out.println(bindingResult.toString());
            return "gallery/write";
        }
        int result = galleryService.write(galleryDto);
        if (result > 0) {
            return "redirect:/gallery/list";
        }
        return "gallery/list";
    }

    // @GetMapping("/json")
    // @ResponseBody
    // public Map<String,List<GalleryDto>> getAllList() {
    //     Map<String,List<GalleryDto>> map = new HashMap();
    //     map.put("list", galleryService.getAllList());
    //     return map;
    // }
    @GetMapping("/json")
    @ResponseBody
    public List<GalleryDto> getAllList() {
        return galleryService.getAllList();
    }

    @GetMapping("/list")
    public String list(Model model) {
        sendCategory(model);
        return "/gallery/list";
    }

    @GetMapping("/list02")
    public String list02(Model model) {
        sendCategory(model);
        model.addAttribute("galleryList", galleryService.getAllList());
        return "/gallery/list02";
    }
}
