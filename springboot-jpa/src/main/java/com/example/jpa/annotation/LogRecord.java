package com.example.jpa.annotation;


import java.lang.annotation.*;

/**
 * LogRecord  自定义注解，实现日志的拦截
 *
 */


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogRecord {

    String value() default "";//设置默认值，解释该注解的作用
}
