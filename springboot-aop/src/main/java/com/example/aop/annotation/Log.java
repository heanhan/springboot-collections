package com.example.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * 自定义一个日志的注解
 * 使用方式，可以在一个类型 也可在一个方法上
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

	String value() default "";
	/**
	 * 模块
	 * @return
	 */
	String module() default  "";

	/**
	 * 操作
	 * @return
	 */
	String operate() default  "";
}
