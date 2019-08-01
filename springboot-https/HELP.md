# Getting Started

### Spring Boot 支持 HTTPS Documentation
For further reference, please consider the following sections:
`

    这里讲的是 Spring Boot 内嵌式 Server 打 jar 包运行的方式，打 WAR 包部署的就不存在要 Spring Boot 支持 HTTPS 了，
    需要去外部对应的 Server 配置。

`

#####1、配置  HTTPS spring boot 2.x配置
 `
 
    Spring Boot 配置 SSL 很简单，只需要通过一系列的 server.ssl.* 参数即可完成配置
    
    server.port=8443
    server.ssl.protocol=TLS
    server.ssl.key-store=classpath:javastack.keystore
    server.ssl.key-store-password=javastack
    server.ssl.key-store-type=JKS
    
    
    通过上面的配置就能开启 HTTPS 了，默认的 HTTP 协议就不再支持了，Spring Boot 不支持以配置文件配置的方式同时支持 HTTP 和 HTTPS。
    
    【注】：把生成完的证书复制到 Spring Boot 项目中的 resources 目录即可
 
 `

#####2、配置 spring boot 2.x配置如何同时支持  HTTPS 和 HTTP

`

    同时支持 HTTP 和 HTTPS 这两个协议，就需要把另外一个协议用程序化的方式来配置。因为通过程序的方式配置 HTTP 协议更加简单一点，
    Spring Boot 推荐的做法是把 HTTPS 配置在配置文件，HTTP 通过程序来配置。
    
    步骤：在启动类中添加，也可单写一个配置 
    
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
        
    启动 Spring Boot 之后就会看到下面的同时支持两个协议日志
    
    Tomcat started on port(s): 8443 (https) 9322 (http) with context path '/'
    
`