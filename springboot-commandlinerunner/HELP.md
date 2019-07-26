# Getting Started

### springboot CommandLineRunner Documentation


`

    在实际工作中，总会遇到这样需求，在项目启动的时候需要做一些初始化的操作，比如初始化线程池，提前加载好加密证书等。今天就给大家介绍一个 Spring Boot 提供一个组件帮助解决项目启动初始化资源操作。
    就是 CommandLineRunner，CommandLineRunner 接口的 Component 会在所有 Spring Beans 都初始化之后，SpringApplication.run() 之前执行，非常适合在应用程序启动之初进行一些数据初始化的工作。


`