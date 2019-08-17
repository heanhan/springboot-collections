package com.example.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : zhaojh
 * @date : 2019-05-11
 * @function :测试页面的跳转
 */

@Controller
@RequestMapping(value = "/page")
public class PageController {

    /**
     * 作用是跳转到 index.htmnl 页面
     * @return  index.html视图
     */
    @GetMapping(value = "/startPage")
    public String startPage(){
        return "index.html";
    }

    @GetMapping(value = "/page1")
    public String index(){
        return "/index.html";
    }

}
