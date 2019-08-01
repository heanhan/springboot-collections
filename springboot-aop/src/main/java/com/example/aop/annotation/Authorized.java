package com.example.aop.annotation;

import java.lang.annotation.*;

/**
 * @author : zhaojh
 * @date : 2019-08-01
 * @function :  安全认证的注解，在需要安全认证的接口方法上或者类上添加此注解
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authorized {

    String value() default "";//
}
