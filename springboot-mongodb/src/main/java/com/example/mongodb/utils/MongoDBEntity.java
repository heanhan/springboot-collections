/**
 * 
 */
package com.example.mongodb.utils;
import com.mongodb.DB;

import java.util.Map;
 
/**
 * @author Thunisoft
 *
 */
public class MongoDBEntity {
 
    /**
     * mongo数据库
     */
    private DB db;
 
    /**
     * 集合名字
     */
    private String collectionName;
 
    /**
     * 字段封装Map
     */
    private Map<String,Object> fieldMap;
 
    public DB getDb() {
        return db;
    }
 
    public void setDb(DB db) {
        this.db = db;
    }
 
    public String getCollectionName() {
        return collectionName;
    }
 
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
 
    public Map<String, Object> getFieldMap() {
        return fieldMap;
    }
 
    public void setFieldMap(Map<String, Object> fieldMap) {
        this.fieldMap = fieldMap;
    }
}