package com.project.picktoon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @GetMapping("/login")
    public String login(){
        return "users/login";
    }

    @GetMapping("/join")
    public String join(){
        return "users/join";
    }


}
