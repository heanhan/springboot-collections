/**
 * 
 */
package com.example.mongodb.utils;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * 根据mongo 自带属性，连接mongodb数据库。
 * @author Thunisoft
 *
 */
/**
 * host ip地址 port 端口 database 数据库名 username 用户名 password 密码
 */
public class MongoDBCommonUtil {
	public static DB getDB(String host, int port, String database, String username, String password) {
		DB db = null;
		try {
			// 连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
			// ServerAddress()两个参数分别为 服务器地址 和 端口
			ServerAddress serverAddress = new ServerAddress(host, port);
			List<ServerAddress> addrs = new ArrayList<ServerAddress>();
			addrs.add(serverAddress);

			// MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
			MongoCredential credential = MongoCredential.createScramSha1Credential(username, database,
					password.toCharArray());
			List<MongoCredential> credentials = new ArrayList<MongoCredential>();
			credentials.add(credential);

			// 通过连接认证获取MongoDB连接
			MongoClient mongoClient = new MongoClient(addrs, credentials);
			db = mongoClient.getDB(database);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return db;
	}

	//通过地址+端口 数据库名  连接mongo 数据库
	public static DB getDBNoUser(String host, int port, String database) {
		DB db = null;
		try {
			// 连接到 mongodb 服务
			MongoClient mongoClient = new MongoClient(host, port);

			// 连接到数据库
			db = mongoClient.getDB(database);
			System.out.println("MongoDB数据库的连接成功");

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return db;
	}

//	public static void main(String[] args) {
//		DB db = MongoDBCommonUtil.getDBNoUser("11.205.243.206", 27017, "null");
//		System.out.println(db.toString());
//	}

	public static DBCollection getCollection(MongoDBCursor mongoDBCursor) {
		DB db = mongoDBCursor.getDb();
		DBCollection collection = db.getCollection(mongoDBCursor.getCollectionName());
		return collection;
	}

	//获取mongo 数据库的操作的collection
	public static DBCollection getCollection(MongoDBEntity mongoDBEntity) {
		DB db = mongoDBEntity.getDb();
		DBCollection collection = db.getCollection(mongoDBEntity.getCollectionName());
		return collection;
	}
}
