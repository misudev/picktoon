package com.project.picktoon.controller;

import com.mysema.commons.lang.Assert;
import com.project.picktoon.service.WebtoonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final WebtoonService webtoonService;

    @GetMapping("/webtoonform")
    public String addWebtoon(){
        return "admin/webtoonform";
    }

    @PostMapping("/webtoonform")
    public String addWebtoon(@RequestParam(name = "name") String name) {

        Assert.hasText(name, "웹툰명을 입력하세요.");

        return "redirect:/admin";
    }
}
