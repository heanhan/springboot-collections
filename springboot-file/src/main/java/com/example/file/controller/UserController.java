package com.example.file.controller;

import com.example.file.pojo.User;
import com.example.file.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value="/addUser")
    public User addUser(User user, MultipartFile file){
        return userService.addUser(user);
    }
}
