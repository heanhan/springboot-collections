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
@Order(2)//@Order()里面的值越小启动越早。
public class RunnerOne implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("springboot 容器启动前初始化配置文件 2");

    }
}
