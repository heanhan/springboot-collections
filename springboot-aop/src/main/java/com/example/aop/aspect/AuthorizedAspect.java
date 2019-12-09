package com.example.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : zhaojh
 * @date : 2019-08-01
 * @function :  对安全认证注解做切面
 */


@Aspect//标识当前是一个切面
@Component
public class AuthorizedAspect {

    @Autowired
    private HttpServletRequest request;

    /**
     * 定义切面表达式
     */

//      @Pointcut("*.*.service.find*(..)")



    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMapping(){

    }

    @Pointcut("@annotation()")
    public void methodPointCut(){


    }
}
