# Getting Started

### 更改默认的Json转换器

       SpringBoot 默认使用的是Jackson ,由于性能的原因，可以使用第三方高性能的引擎如 FastJson.
       下面介绍使用FastJson .
       1、引入pom 坐标
                <dependency>
                        <groupId>com.alibaba</groupId>
                        <artifactId>fastjson</artifactId>
                        <version>1.2.58</version>
                 </dependency>
        2、创建一个配置类，继承WebMvcConfigurationSupport，重写configuteMessageConverters
        