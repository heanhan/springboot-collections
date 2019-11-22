package com.example.aop.controller;

import com.example.aop.annotation.Log;
import com.example.aop.entity.pojo.User;
import com.example.aop.service.IUserService;
import com.example.common.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhaojh
 * @date : 2019-11-22
 * @function :
 */

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IdWorker idWorker;

    //添加用户
    @Log(module = "添加用户",operate = "进行单个用户进行添加")
    @PostMapping(value = "/addUserInfo")
    public String addUserInfo(){
        String id=idWorker.nextId()+"";
        User user =new User(id,"zhoajh","123456",23);
        int i = userService.addUserInfo(user);
        if(i>0){
            return "success";
        }else{
            return "fail";
        }
    }
}
