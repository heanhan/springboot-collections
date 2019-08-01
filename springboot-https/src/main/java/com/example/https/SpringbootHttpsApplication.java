package com.example.https;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootHttpsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHttpsApplication.class, args);
    }


    /**
     * 通过配置的方式 实现该服务实现同时支持HTTP 、HTTPS的协议
     */
    @Bean
    public ServletWebServerFactory servletWebServerFactory(){
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
        return tomcat;
    }

    private Connector createStandardConnector(){

        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(9322);
        return connector;
    }

}
