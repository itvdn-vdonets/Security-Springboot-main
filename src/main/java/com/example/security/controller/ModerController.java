package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/moder")
public class ModerController {
    @RequestMapping("/dashboard")
    public String showDashboard(){
        return "moderator-dashboard";
    }
}
