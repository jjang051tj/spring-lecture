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

    @GetMapping("/write")
    public String write(Model model) {
        Map<String,String> map = new HashMap<>();
        map.put("paint","Paint");
        map.put("photo","Photo");
        map.put("sketch","Sketch");
        model.addAttribute("galleryDto", new GalleryDto());
        model.addAttribute("category", map);
        return "gallery/write";
    }

    @PostMapping("/write")
    public String write(@Valid @ModelAttribute GalleryDto galleryDto,
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "gallery/write";
        }
        int result = galleryService.write(galleryDto);
        if (result > 0) {
            return "redirect:/gallery/list";
        }
        return "gallery/list";
    }

    @GetMapping("/json")
    @ResponseBody
    public List<GalleryDto> getAllList() {
        galleryService.getAllList();
        return galleryService.getAllList();
    }

    @GetMapping("/list")
    public String list() {
        return "/gallery/list";
    }
}
