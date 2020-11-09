package com.ifv.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminAPI {
    @GetMapping("/")
    public String hello() {
        return "Hello Admin";
    }
    @GetMapping("/abc")
    public String hello2() {
        return "Hello Admin";
    }
}
