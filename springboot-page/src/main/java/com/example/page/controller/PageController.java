package com.example.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @GetMapping(value = "/index")
    public String index(Model model){
        String name ="zhaojh0912";
        model.addAttribute("name",name);
        return "index";
    }

}
