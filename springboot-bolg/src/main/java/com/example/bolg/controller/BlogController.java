package com.example.bolg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : zhaojh
 * @date : 2019-08-23
 * @function :
 */

@Controller
public class BlogController {

    /**
     * 作用是跳转到 index.htmnl 页面
     * @return  index.html视图
     */
    @GetMapping(value = "/index")
    public String index(Model model){
        String name ="zhaojh0912";
        model.addAttribute("name",name);
        return "index";
    }


}
