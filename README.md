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
    1、
