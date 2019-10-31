package com.example.mvc.controller;

import com.example.mvc.pojo.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-10-31
 * @function :
 */

@Slf4j
@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @PostMapping(value = "/saveAdmin")
    public String saveAdmin(@RequestBody Admin admin){

        log.info("操作成功！");
        List<String> hobby = admin.getHobby();

        return "OK!";

    }
}
