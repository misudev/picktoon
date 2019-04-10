package com.project.picktoon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/webtoons")
@RequiredArgsConstructor
public class WebtoonController {

    @GetMapping("/searchform")
    public String search(){
        return "webtoons/search";
    }

    @GetMapping("/search")
    public String searchWebtoon() { return "webtoons/searchlist";}
}
