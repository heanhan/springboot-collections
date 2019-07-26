package com.example.commandlinerunner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringbootCommandlinerunnerApplication {

    public static void main(String[] args) {
        log.info("springboot 容器开始启动......");
        SpringApplication.run(SpringbootCommandlinerunnerApplication.class, args);
        log.info("springboot 容器已经启动......");
    }

}
