# Getting Started

### springboot admin Documentation

Spring Boot Admin 是一个管理和监控 Spring Boot 应用程序的开源软件。每个应用都认为是一个客户端，通过 HTTP 或者使用 Eureka 注册到 admin server 中进行展示，Spring Boot Admin UI 部分使用 VueJs 将数据展示在前端。


`
    
    1、使用，添加pom[2019-07  最新版本 2.1.5]
    
        <dependency>
            <groupId>de.codecentric</groupId>
            <artifactId>spring-boot-admin-starter-server</artifactId>
            <version>2.1.5</version>
        </dependency>
      
    2、开启，在启动类上添加注解
      
      @EnableAdminServer
      
    3、完成上面两步之后，启动服务端，浏览器访问http://localhost:port可以看到

    4、Admin client
    
        添加依赖pom
    
        <dependency>
          <groupId>de.codecentric</groupId>
          <artifactId>spring-boot-admin-starter-client</artifactId>
          <version>2.1.5</version>
        </dependency>
        
        
        在application.properties 中添加如下配置
        
        spring.boot.admin.client.url=http://localhost:port  //admin server 的服务地址
        management.endpoints.web.exposure.include=*
        
`

**监控微服务**

    `
        如果使用的是单个 Spring Boot 应用，就需要在每一个被监控的应用中配置 Admin Server 的地址信息；如果应用都注册在 Eureka 中就不需要再对每个应用进行配置，Spring Boot Admin 会自动从注册中心抓取应用的相关信息。
        
        如果使用了 Spring Cloud 的服务发现功能，就不需要在单独添加 Admin Client 客户端，仅仅需要 Spring Boot Server ,其它内容会自动进行配置。
        
        接下来我们以 Eureka 作为服务发现的示例来进行演示，实际上也可以使用 Consul 或者 Zookeeper。
        
        1、服务端和客户端添加 spring-cloud-starter-eureka 到包依赖中
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
            </dependency>
            
        2、启动类添加注解
        
            @EnableDiscoveryClient
            @EnableAdminServer
            public class SpringBootAdminApplication {
                public static void main(String[] args) {
                    SpringApplication.run(SpringBootAdminApplication.class, args);
                }
            
                //使用类 SecurityPermitAllConfig 关闭了安全验证。
                @Configuration
                public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
                    @Override
                    protected void configure(HttpSecurity http) throws Exception {
                        http.authorizeRequests().anyRequest().permitAll()  
                            .and().csrf().disable();
                    }
                }
            }
        
        3、在客户端中配置服务发现的地址
    `

    
