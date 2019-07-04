package com.example.taskjobs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * 使用注解@EnableScheduling  开起注解
 */
@SpringBootApplication
@EnableScheduling
public class SpringbootTaskjobsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTaskjobsApplication.class, args);
    }

}
