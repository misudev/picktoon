package com.project.picktoon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String start(){
        return "index";
    }

    @GetMapping("/users/join")
    public String join() {  return "join";}

    @GetMapping("/addwebtoon")
    public String addwebtoon() {  return "addwebtoon"; }
}
