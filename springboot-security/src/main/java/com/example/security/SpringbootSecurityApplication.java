package com.example.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


/**
 * 使用开启spring security 有两个重要的注解
 * @EnableWebSecurity   : 在web项目中使用
 * @EnableGlobalMethodSecurity  ：该注解在非web项中用，其实上一个注解包含了本注解。
 */
@SpringBootApplication
@EnableWebSecurity
public class SpringbootSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurityApplication.class, args);
    }

}
