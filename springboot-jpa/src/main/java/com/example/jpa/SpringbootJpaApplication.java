package com.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;


/**
 * @EnableSpringDataWebSupport 该注解是的spring-boot-jpa 支持WebMvc
 */
@SpringBootApplication
@EnableSpringDataWebSupport
public class SpringbootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaApplication.class, args);
    }

}
