package com.example.SpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/admin")
    public String adminHome()
    {
        return "Welcome Admin!";
    }
    @GetMapping("/learner")
    public String learnerHome()
    {
        return "Welcome Learner!";
    }
}
