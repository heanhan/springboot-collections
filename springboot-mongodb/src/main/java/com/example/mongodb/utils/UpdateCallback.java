/**
 * 
 */
package com.example.mongodb.utils;

import com.mongodb.DBObject;

/**
 * MongoDB更新操作接口定义
 * 
 * @author Thunisoft
 *
 */
interface UpdateCallback {

	DBObject doCallback(DBObject valueDBObject);
}