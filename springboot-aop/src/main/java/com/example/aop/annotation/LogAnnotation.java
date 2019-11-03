package com.example.aop.annotation;


import java.lang.annotation.*;


/**
 * 自定义一个日志的注解
 * 使用方式，可以在一个类型 也可在一个方法上
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {

    String value() default "";
}
