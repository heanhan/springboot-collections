/**
 * 
 */
package com.example.mongodb.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @author Thunisoft
 *
 */
public class ConnectionMongo {

	// 获得mongo数据库的信息
	public static MongoClient getMogoClient(String host, int port, String username, String databasenane,
			String password) {
		// 如果mogodb 需要数据库有用户名登录密码
		if (username != null && password != null) {
			ServerAddress serverAddress = new ServerAddress(host, port);
			List<ServerAddress> addrs = new ArrayList<ServerAddress>();
			addrs.add(serverAddress);
			MongoCredential credential = MongoCredential.createScramSha1Credential(username, databasenane,
					password.toCharArray());
			List<MongoCredential> credentials = new ArrayList<MongoCredential>();
			credentials.add(credential);
			MongoClient mongoClient = new MongoClient(addrs, credentials);// mongo数据库库ip
			return mongoClient;
//new MongoClient("mongodb://admin:123456@128.0.0.1:27017/test");
		} else {
			MongoClient mongoClient = new MongoClient("mongodb://128.0.0.1:27017");// 创建连接
			return mongoClient;
		}
	}

	/*
	 * public static void main(String[] args) { MongoClient mongoClient =
	 * ConnectionMongo.getMogoClient("127.0.0.1", 27017, "", "springboot-dbs", "");
	 * MongoDatabase mongoDatabase = mongoClient.getDatabase("springboot-dbs");//
	 * 数据库名 MongoCollection<Document> spit =
	 * mongoDatabase.getCollection("student-db");// 获取文档名称 BasicDBObject bson=new
	 * BasicDBObject("userid","1013");// 构建查询
	 * 
	 * Map<String, Object> map = new HashMap(); map.put("content", "我要吐槽");
	 * map.put("userid", "9999"); map.put("visits", 123); map.put("publishtime", new
	 * Date()); Document document = new Document(map); spit.insertOne(document);//
	 * 插入数据 mongoClient.close();// 关闭mongo数据库 }
	 */
}
