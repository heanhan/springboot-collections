package com.example.mvc.controller;

import com.example.mvc.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : zhaojh
 * @date : 2019-09-18
 * @function :
 */

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;


    /**
     * 测试使用request 的方法。
     * @param param
     * @return
     */
    @GetMapping(value = "/testRequestMethod")
    public String testRequestMethod(String param){

        log.info("request.getMethod()"+" ："+request.getMethod());
        log.info(""+" : "+request.getSession());
        log.info(""+" : "+request.getRemoteAddr());
        log.info(""+" : "+request.getContextPath());
        log.info(""+" : "+request.getParameter(param));
        log.info(""+" : "+request.getAuthType());
        log.info(""+" : "+request.getHeader(param));
        log.info(""+" : "+request.getQueryString());
        log.info(""+" : "+request.getPathInfo());
        log.info(""+" : "+request.getPathTranslated());
        log.info(""+" : "+request.getRemoteUser());
        log.info(""+" : "+request.getRequestedSessionId());
        log.info(""+" : "+request.getRequestURI());
        log.info(""+" : "+request.getServletPath());
        log.info(""+" : "+request.getProtocol());
        log.info(""+" : "+request.getCharacterEncoding());
        log.info(""+" : "+request.getContentType());
        log.info(""+" : "+request.getLocalAddr());
        log.info(""+" : "+request.getLocalName());
        log.info(""+" : "+request.getHttpServletMapping());
        return "查询成功！";
    }


    /**
     * 通过Get ，springmvc 自动帮转换类型
     * @param id id
     * @return String
     */

    @GetMapping(value = "/findUserById")
    public String findUserById(Integer id){
        log.info("接收的参数为："+id);
        return "接收的参数为："+id;
    }

    /**
     * 使用@PathVariable 风格
     * @param id id
     * @return String
     */
    @GetMapping(value = "/findUserById1/{id}")
    public String findUserById1(@PathVariable String id){
        log.info("接收的参数为："+id);
        return "接收的参数为："+id;
    }


    /**
     * 使用Post 请求
     * @param id id
     * @return String
     */
    @PostMapping(value = "/findUserById2")
    public String findUserById2(String id){
        log.info("使用"+request.getMethod()+"接收的参数为："+id);
        return "接收的参数为："+id;
    }

    /**
     * 使用Post 请求,使用 @PathVariable
     * @param id id
     * @return String
     */
    @PostMapping(value = "/findUserById3/{id}")
    public String findUserById3(@PathVariable  String id){
        log.info("使用"+request.getMethod()+"接收的参数为："+id);
        return "接收的参数为："+id;
    }

    @PostMapping(value = "/findByUser")
    public String findByUser(User user){
        return "";
    }

}
