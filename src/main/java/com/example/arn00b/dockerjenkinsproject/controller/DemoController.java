package com.example.arn00b.dockerjenkinsproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/")
    public String Welcome() {
        return "Hello World. Version-1.0";
    }
}
