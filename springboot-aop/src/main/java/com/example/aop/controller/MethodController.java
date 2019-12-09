package com.example.aop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author : zhaojh
 * @date : 2019-12-09
 * @function :测试对增删改查的方法拦截
 */

@RestController
@RequestMapping(value = "/method")
@Slf4j
public class MethodController {

    @GetMapping(value = "/findMethodOne")
    public String findMethodOne(String name,String password){
        log.info("进入查询的方法...");

        return "success";

    }

    @PostMapping(value = "/addMethodOne")
    public String addMethodOne(String name,String password){
        log.info("进入添加的方法...");
        return "success";

    }

    @PutMapping(value = "/updateMethodOne")
    public String updateMethodOne(String name,String password){
        log.info("进入更新的方法...");

        return "success";
    }

    @DeleteMapping(value = "/deleteMethodOne")
    public String deleteMethodOne(String name,String password){
        log.info("进入删除的方法...");
        return "success";
    }


}
