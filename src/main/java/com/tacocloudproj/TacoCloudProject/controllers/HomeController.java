package com.tacocloudproj.TacoCloudProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/d")
    public String home() {
        return "home";
    }
}
