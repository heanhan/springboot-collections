package com.example.tkmapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * @MapperSacn  使用tk-mybatis的注解
 */
@MapperScan(basePackages = {"com.example.tkmapper.mapper"})
@SpringBootApplication
public class SpringbootTkMapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTkMapperApplication.class, args);
    }

}
