package com.kpi.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/sign-in")
    public String signIn() {
        return "sign-in/index";
    }

    @GetMapping("/sign-up")
    public String signUp() {
        return "sign-up/index";
    }
}
