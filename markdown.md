##SpringBoot Starter机制和资源文件的读取

* SpringBoot 读取自定义配置文件
       
     
     1、涉及到两个重要的注解
         @EnableConfigurationProperties
         @ConfigurationProperties
         
         作用说明：
         
            @ConfigurationProperties注解的作用是把yml或者properties配置文件转化为对应bean。
            
            @EnableConfigurationProperties注解的作用是使@ConfigurationProperties注解生效。
            
     2、读取自定义的配置文件 .properties 或者.yml 配置文件。
     
        如：mail.properties配置文件
        
        通过通过在配置类中添加两个重要的注解。
        @ConfigurationProperties(prefix = "mail")        //配置文件中以某个字段开头
        @PropertySource("classpath:/mail.properties")    //读到配置文件
        就可以读取我们自己定义的资源文件了
     3、待续.....