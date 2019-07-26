package com.example.swagger.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author : zhaojh
 * @date : 2019-07-25
 * @function :
 */

@Configuration//标记位配置类
@EnableSwagger2//开启在线接口文档
@ConditionalOnProperty(name = "spring.swagger.enable",havingValue = "true")
public class Swagger2Config {

    /**
     * 添加摘要信息(Docket)
     */

    //指定扫描哪些包
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggeInfo())
                .select()
                //要扫描的包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    //配置swagger的基本信息
    private ApiInfo swaggeInfo(){
        return new ApiInfoBuilder()
                .title("Spring Boot 测试使用 Swagger2")
                //创始人
                .contact(new Contact("swagger-git","https://github.com/swagger-api/swagger-ui/",""))
                //版本
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }


}
