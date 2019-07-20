package com.example.jpa.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author : zhaojh
 * @date : 2019-07-20
 * @function : 改切面作为日志使用
 *             切面---->识点回顾  Aspect Oriented Programming ,程序执行中与主业务逻辑不相关的代码提取出来，
 *
 *
 */

@Aspect  //该注解标记当前该类为一个切面。
@Component
public class JpaAspect {

    /**
     * 切面的重要的几个注解
     *  @Before 前置通知
     *  @Around 环绕通知
     *  @After  后置通知
     *  @AfterReturning 返回后通知
     *  @AfterThrowing  异常通知
     */


}
