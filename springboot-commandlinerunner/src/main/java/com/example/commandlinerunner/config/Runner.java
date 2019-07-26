package com.example.commandlinerunner.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author : zhaojh
 * @date : 2019-07-26
 * @function :
 */

@Slf4j
@Component
@Order(1)//@Order()里面的值越小启动越早。
public class Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("在springboot 容器启动前，进行资源初始化......1");

    }
}
