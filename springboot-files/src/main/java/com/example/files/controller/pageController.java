package com.example.files.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/page")
@Slf4j
public class pageController {

    @RequestMapping(value="/index")
    public String index(){
        log.info("进入Controller ...");
        return "index.html";
    }
}
