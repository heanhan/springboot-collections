CentOS 7中安装配置mongdb
===


# 配置mongodb

**配置环境变量**

	vim /etc/profile
	#加入环境变量
	MONGODB_HOME=/usr/local/install/mongodb
	PATH=$PATH:$MONGODB_HOME/bin

**创建数据库目录以及日志目录**

	mkdir -p /usr/local/mongodb/data
	mkdir -p /usr/local/mongodb/logs
		在log 文件夹 下创建一个mongo.log文件
		vi mongo.log

**创建配置文件**
	
	vi mongo.conf

**加入以下内容**

	dbpath=/usr/local/install/mongodb/data  # 自己的实际安装的路径
	logpath=/usr/local/install/mongodb/logs/mongo.log #事先创建该文件
	logappend=true
	journal=true
	quiet=true
	port=27017
	fork=true #后台运行
	bind_ip=0.0.0.0 #允许任何IP进行连接

**启动服务**

	#进入根目录
	cd /usr/local/mongodb/mongodb-linux-x86_64-3.6.13
	#使用配置文件启动服务
	bin/mongod -f /usr/local/mongodb/mongo.conf

**进入shel**

	bin/mongo