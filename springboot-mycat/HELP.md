# Getting Started

### springboot+mycat 使用 Documentation
mycat 的官网地址： http://www.mycat.io/ :

##### 关于mycat

    什么事mycat 
        1、一个彻底开源的、面向企业应用开发的大数据库集群
        2、支持事务ACID，可替代Mysql的加强版数据库中间件。
        3、一个可以视为mysql的集群企业级的数据库，用来替代昂贵的oracle数据库。
        
        
    为何要使用mycat 
        1、支持mysql、Oracle 、DB2、SQL Server、PostgresSQL等常见的DB 数据库。
        2、遵循mysql的原生协议，跨语言的、跨平台、跨数据库，的通用中间件。
        3、基于心跳的自动故障切换，支持读写分离，支持mysql的主从，以及galera cluster 集群。
        4、基于NIO ，有效线程，解决高并发问题。
        5、支持数据的多片的自动路由与聚合，



详细介绍的Mycat 的使用。

* 什么是mycat
* Mycat 的应用场景
* 使用Mycat路由实现读写分离
* springboot 动态数据源的切换原理
* soringboot 的项目实现读写分离

##### 使用Mycat 的实现读写分离的

    ① 什么是mycat呢
    
    mycat 是一款由阿里Cobar演变过来用于支持数据库，读写分离，分库分表的分布式中间件。mycat支持Oracle、mysql、pg、DB2等等主流数据库。
    同时也支持MongoDB非关系型数据库。
    mycat原理主要使用过对sql拦截，然后经过一定规则分片解析、路由分析、缓存分析等，然后将sql发给后端真实的数据块，并将返回的记过做适当处理返回给客户端。
    
    ② 基于mycat的读写分离
    
    读写分离，简单的说就是把对数据库的读和写操作分开，以对应不同的数据库服务器。主数据库提供写操作，从数据库提供读操作，这样有效的减轻单台数据库的
    压力，主数据库的写操作后，数据库即时同步到所读的数据库（从），尽可能的保证读、写数据库的数据一致，比如，mysql的主从复制、Oracle的data grard\
    
    
    读： select
    
    写： select/update/insert/crate/delete
    
    MyCat拦截客户端的所有JDBC,根据sql语句判断转发到不同的数据库执行


MyCat安装：

    Linux环境安装MyCat实现读写分离
    1、上传安装Mycat-server-1.6.5-release-20180122220033-linux.tar
    2、解压安装包tar –zxvf 
    3、配置schema.xml 和server.xml
    4、客户端连接端口号: 8066
    
MyCat需要虚拟出一个数据库，客户端连接的是一个虚拟的数据库。

    读写分离：第一方面肯定是要根据SQL语句  第二是根据连接账号
    
    主要配置：
    
    server.xml  :mycat的配置文件，设置账号、参数等
    schema.xml  ：mycat对应的物理数据库和数据库表的配置。
    rule.xml    ：mycat分片（f分表分库）规则