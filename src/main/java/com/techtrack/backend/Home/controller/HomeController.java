package com.techtrack.backend.Home.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello TechTrack!";
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "Application is running!";
    }
}

