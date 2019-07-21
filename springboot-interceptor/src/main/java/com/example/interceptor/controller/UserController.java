package com.example.interceptor.controller;

import com.example.interceptor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhaojh
 * @date : 2019-07-21
 * @function : 控制器
 */

@RestController
@RequestMapping(value="/interceptor")
public class UserController {

    @Autowired
    private UserService userService;


}
