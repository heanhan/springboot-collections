package com.example.sessions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: IndexController
 * @Author: zhaojh0912
 * @Dae: 2020-02-09
 * @Vsersion: 1.0.0
 * @Description: TOO
 */
@RestController
@RequestMapping(value = "/session")
public class IndexController {

    @GetMapping(value = "/setSession")
    public Map<String, Object> setSession(HttpServletRequest request) {
        // 添加数据到Session
        request.getSession().setAttribute("username", "admin");
        // 添加sessionID到Map
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        return map;
    }

    @GetMapping(value = "/get")
    public String get(HttpServletRequest request) {
        // 获取Session数据
        String userName = (String) request.getSession().getAttribute("username");
        return userName;
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        // 销毁sessioin
        request.getSession().invalidate();
        return "ok";
    }
}
