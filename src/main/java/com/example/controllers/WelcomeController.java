package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

// sebagai endpoint
@RequestMapping("/api/welcome")
public class WelcomeController {

    // sebagai request GET
    @GetMapping
    public String welcome() {
        return "Hello World";
    }

    // sebagai request POST
    @PostMapping
    public String welcome2() {
        return "Hello World 2";
    }

}
