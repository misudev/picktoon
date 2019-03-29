package com.project.picktoon.controller;

import com.project.picktoon.service.WebtoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    WebtoonService webtoonService;
    @GetMapping("/")
    public String start(){
        return "index";
    }

    @GetMapping("/users/join")
    public String join() {
        return "join";}

    @GetMapping("/addwebtoon")
    public String addwebtoon() {  return "addwebtoon"; }
}
