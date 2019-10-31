LiunxCentOS 7.x安装elasticsearch7.3
 

 1. Elasticsearch下载地址：
  

wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-7.3.0-linux-x86_64.tar.gz

2. 解压elasticsearch-7.3.0-linux-x86_64.tar.gz
 tar -avxf elasticsearch-7.3.0-linux-x86_64.tar.gz
3 进入解压后的elasticsearch目录：

  3.1. 新建data目录

mkdir data

  3.2. 修改config/elasticsearch.yml：

vim config/elasticsearch.yml

 取消下列项注释并修改：
 

cluster.name: my-cluster #集群名称
node.name: node-1 #节点名称
#数据和日志的存储目录
path.data: /opt/elasticsearch-7.3.0/data
path.logs: /opt/elasticsearch-7.3.0/logs
#设置绑定的ip，设置为0.0.0.0以后就可以让任何计算机节点访问到了
network.host: 0.0.0.0
http.port: 9200 #端口
#设置在集群中的所有节点名称，这个节点名称就是之前所修改的，当然你也可以采用默认的也行，目前是单机，放入一个节点即可
cluster.initial_master_nodes: ["node-1"]

修改完后保存

4 准备启动es 
./bin/elasticsearch

  我这里出现错误：

Java HotSpot(TM) 64-Bit Server VM warning: INFO: os::commit_memory(0x00000000c5330000, 986513408, 0) failed; error='Cannot allocate memory' (errno=12)
 修改elasticsearch下config jvm.options 

    vim ./config/jvm.options 

  修改该内容：

   

 -Xms512m
 -Xmx512m

    
 保存并退出，再次启动es

 再次启动出现如下错误：

 [node-1] uncaught exception in thread [main]
org.elasticsearch.bootstrap.StartupException: java.lang.RuntimeException: can not run elasticsearch as root
 这是不能使用root用户操作，添加一个其他的用户再试试：

[root@KM-T-KMT-202d36 elasticsearch-7.3.0]# adduser esuser
[root@KM-T-KMT-202d36 elasticsearch-7.3.0]# passwd esuser
Changing password for user esuser.
New password: 
Retype new password: 
passwd: all authentication tokens updated successfully.
 改一下esuser目录所属用户权限：

[root@KM-T-KMT-202d36 elasticsearch-7.3.0]# chown esuser /opt/elasticsearch-7.3.0/ -R
 

[root@KM-T-KMT-202d36 elasticsearch-7.3.0]# su esuser
[esuser@KM-T-KMT-202d36 elasticsearch-7.3.0]$ ./bin/elasticsearch
 

 测试一下：http://10.202.202.36:9200/
 

{
    "name": "node-1",
    "cluster_name": "elasticsearch",
    "cluster_uuid": "M-JTUQ9QTt6aCPjX4C9-UQ",
    "version": {
    "number": "7.3.0",
    "build_flavor": "default",
    "build_type": "tar",
    "build_hash": "de777fa",
    "build_date": "2019-07-24T18:30:11.767338Z",
    "build_snapshot": false,
    "lucene_version": "8.1.0",
    "minimum_wire_compatibility_version": "6.8.0",
    "minimum_index_compatibility_version": "6.0.0-beta1"
    },
    "tagline": "You Know, for Search"
}
 5.后台启动：
    
 ./bin/elasticsearch -d

   查看进程：

ps -ef|grep java

更多优雅启动可以见官网连接

   

    启动es
    https://www.elastic.co/guide/en/elasticsearch/reference/current/starting-elasticsearch.html
    停止es
    https://www.elastic.co/guide/en/elasticsearch/reference/current/stopping-elasticsearch.html
END 

  elasticsearch7.3


恶搞一下
十年笛子万年萧，一把二胡穿云霄，前年琵琶