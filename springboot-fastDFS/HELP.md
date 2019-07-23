# Getting Started

### springboot+docker+fastDFS 搭建分布式分拣系统  Documentation
For further reference, please consider the following sections:

* 知识点总结

### Guides
**docker安装fastDFS**

`
    
    fastdfs 安装
    //1、拉取镜像
    docker pull morunchang/fastdfs
    //2、启动tracker
    docker run -d --name tracker --net=host morunchang/fastdfs sh tracker.sh
    //3、启动storage （192.168.187.128 ip 自行替换为docker 所在服务器的ip )( 此镜像不支持-p 参数）
    docker run -d --name storage --net=host -e TRACKER_IP=192.168.187.128:22122 -e GROUP_NAME=group1 morunchang/fastdfs sh storage.sh
    //4、防火墙添加端口 
    // 22122/23000 文件上传使用，不建议修改
    // 8080 为storage容器中nginx的端口，用于浏览器文件访问使用，默认为8080，如需修改，请参考可选配置 建议修改
    firewall-cmd --zone=public --add-port=22122/tcp --permanent
    firewall-cmd --zone=public --add-port=23000/tcp --permanent
    firewall-cmd --zone=public --add-port=8080/tcp --permanent
    firewall-cmd --reload
    
    可选配置
    storage 内部nginx 端口修改 以22999为例
    //1.进入容器内部
    docker exec -it storage /bin/bash
    //2.修改nginx配置文件 /etc/nginx/conf/nginx.conf
    修改 http.server.listen 8080 为 22999
    sed -i 's/8080/22999/g' /etc/nginx/conf/nginx.conf
    //3.退出容器
    exit
    //4.重启storage
    docker restart storage
    //5.添加防火墙端口
    firewall-cmd --zone=public --add-port=22999/tcp --permanent
    firewall-cmd --reload
    //浏览器访问路径 http://192.168.187.128:22999/group1/M00/00/00/rBVb2lwPNYeAZtTLAAAXxD4H4Z8674.txt
    
    
    默认安装命令 //替换192.168.187.128
    docker run -d --name tracker --net=host morunchang/fastdfs sh tracker.sh
    docker run -d --name storage --net=host -e TRACKER_IP=192.168.187.128:22122 -e GROUP_NAME=group1 morunchang/fastdfs sh storage.sh
    firewall-cmd --zone=public --add-port=22122/tcp --permanent
    firewall-cmd --zone=public --add-port=23000/tcp --permanent
    firewall-cmd --zone=public --add-port=8080/tcp --permanent
    firewall-cmd --reload
    
    建议安装命令 //替换172.21.91.218
    docker run -d --name tracker --net=host morunchang/fastdfs sh tracker.sh
    docker run -d --name storage --net=host -e TRACKER_IP=192.168.187.128:22122 -e GROUP_NAME=group1 morunchang/fastdfs sh storage.sh
    docker exec -it storage /bin/bash
    sed -i 's/8080/22999/g' /etc/nginx/conf/nginx.conf
    exit
    docker restart storage
    firewall-cmd --zone=public --add-port=22122/tcp --permanent
    firewall-cmd --zone=public --add-port=23000/tcp --permanent
    firewall-cmd --zone=public --add-port=22999/tcp --permanent
    firewall-cmd --reload

    
`

**注意**

`

    解决idea 使用Maven无法下载 fastdfs-client-java 的pom 
    
        git clone https://github.com/happyfish100/fastdfs-client-java.git
        # 进入下载好的fastdfs-client-java 解压
        $ cd /fastdfs-client-java 
        # 使用maven打包jar
        $ mvn clean install 

    会自动把fastdfs-client-java-1.27-SNAPSHOT.jar安装到本地的Maven仓库

`