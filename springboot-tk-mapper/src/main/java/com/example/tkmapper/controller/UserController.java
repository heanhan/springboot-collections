package com.example.tkmapper.controller;

import com.example.tkmapper.pojo.User;
import com.example.tkmapper.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-08-07
 * @function :
 */


@RestController
@RequestMapping(value = "/tk")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/findById")
    public List<User> findById(){
        List<User> user = userService.findById();
        return user;
    }
}