package com.example.socket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String inxdex(){
        return "Hello world!Hello CXL!!";
    }
}
