####在linux 上部署tomcat 环境
    1、下载安装tomcat 
    编辑环境变量  vim /etc/profile
    加入一下代码（tomcat 路径要配置自己实际安装tomcat 的安装路径）
        #配置tomcat 1
        
        CATALINA_BASE=/usr/local/install/tomcat-springboot-one/apache-tomcat-9.0.24
        
        CATALINA_HOME=/usr/local/install/tomcat-springboot-one/apache-tomcat-9.0.24
        
        TOMCAT_HOME=/usr/local/install/tomcat-springboot-one/apache-tomcat-9.0.24
        
        #配置tomcat 2
        CATALINA_2_BASE=/usr/local/install/tomcat-springboot-two/apache-tomcat-9.0.24
        
        CATALINA_2_HOME=/usr/local/install/tomcat-springboot-two/apache-tomcat-9.0.24
        
        TOMCAT_2_HOME=/usr/local/install/tomcat-springboot-two/apache-tomcat-9.0.24
        
        export CATALINA_2_BASE CATALINA_2_HOME TOMCAT_2_HOME
        
        ......
        
        然后保存退出：   shift+ z z
        再输入：source /etc/profile  让配置文件生效。
        
        
        
    2、配置启动
     第一个tomcat 不用修改。只需要修改后面的几个tomcat 即可
     详细如下：
        a. 进入 bin目录下找到catalina.sh 文件 找到【# OS specific support.  $var _must_ be set to either true or false.】标识部分。
        使用vim 打开编辑，增加一下代码
        
        export CATALINA_BASE=$CATALINA_2_BASE
        export CATALINA_HOME=$CATALINA_2_HOME
        
        如有多个只需要在对应的tomcat 的bin 目录下找到catalina.sh文件，添加上述步骤的代码即可。
        
        
     3. 配置对应的的tomcat 的congf 目录下修改server.xml 
     
        <Server port="9005" shutdown="SHUTDOWN">　               端口：8005->9005
        <!-- Define a non-SSL HTTP/1.1 Connector on port 8080 -->
            <Connector port="9080" maxHttpHeaderSize="8192"　       端口：8080->9080
        maxThreads="150" minSpareThreads="25" maxSpareThreads="75"
                       enableLookups="false" redirectPort="8443" acceptCount="100"
                       connectionTimeout="20000" disableUploadTimeout="true" />
        <!-- Define an AJP 1.3 Connector on port 8009 -->
            <Connector port="9009"                                  端口：8009->9009
                       enableLookups="false" redirectPort="8443" protocol="AJP/1.3" />
                       
                       
                       
                       
        