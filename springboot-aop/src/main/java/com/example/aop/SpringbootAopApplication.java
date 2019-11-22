package com.example.aop;

import com.example.aop.annotation.Authorized;
import com.example.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringbootAopApplication {

    @Authorized
    @GetMapping()
    public void test(){

    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAopApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }

}
