package com.example.mongodb;

import com.example.mongodb.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongodbApplication.class, args);
    }


    /**
     * 添加雪花算法的使用
     */
    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
