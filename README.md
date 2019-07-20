# springboot-collections
springboot各个知识点的学习

Maven打包过程的问题

    跳过测试：
    
        方法1：添加build
        `<build>  
                 <plugins>  
                   <plugin>  
                     <groupId>org.apache.maven.plugins</groupId>  
                     <artifactId>maven-surefire-plugin</artifactId>  
                     <version>2.18.1</version>  
                     <configuration>  
                       <skipTests>true</skipTests>  
                     </configuration>  
                   </plugin>  
                 </plugins>  
               </build>`
        
        

        方法2：使用命令 mvn install -DskipTests
        或者mvn install -DMaven.test.skip=true
各个模块的使用清单：

    1、springboot-common ：springboot 各个功能模块抽取出来的工具类。
    
    2、springboot-crossorigin : 跨域的解决 知识点
    
    3、springboot-file : 文件上传模块。
    
    4、springboot-fileupload ： 作为更换头像，并实时显示。
    
    5、springboot-ftp-jsch :FTP上传 不使用FtpClient 的方式。
    
    6、springboot-getValue ： springboot 读取自定义的配置文件属性方式。
    
    7、springboot-html： 写一个springboot结合前端的简单页面。
    
    8、springboot-httpclient :HttpClient 的使用。
    
    9、springboot-mongodb :使用mongodb 的nosql数据库
    
    10、springboot-mybatis ： 使用ORM吃就成框架之mybatis,
    
    11、springboot-mycat : 使用分表分库的中间件 mycat
    
    12、springboot-pdf : 基于springboot 进行pdf 的操作。
    
    13、springboot-poi： 基于springboot、阿里easypoi。练习Excel的导入导出功能。
    
    14、springboot-readsql :使用springboot 读取sql文件
    
    15、springboot-redis : springboot 环境下利用spring-data-redis，操作redis.
    
    16、springboot-shiro :学习shiro的权限管理框架。
    
    17、springboot-socket : 整合socket的知识点学习梳理。
    
    18、springboot-taskjob : 使用定时任务。
    
    19、springboot-web : springboot结合jQery.
    
    20、springboot-websocket : 整合websocket的使用。
    
    21、springboot-xml ：springboot学习xml的读取与解析。
    
    22、springboot-jpa : 基于spring-data-jpa 在springboot 下学习  jpa 知识。
