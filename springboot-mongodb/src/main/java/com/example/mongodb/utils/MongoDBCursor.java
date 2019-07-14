/**
 * 
 */
package com.example.mongodb.utils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
 
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
 

/**
 * @author Thunisoft
 *
 */
public class MongoDBCursor extends MongoDBEntity {
 
    /**
     * skip属性
     */
    private int skip;
 
    /**
     * limit属性
     */
    private int limit = 100;
 
    /**
     * 排序属性
     */
    private Map<String, Object> sort = new LinkedHashMap<String, Object>();
 
    /**
     * 自定义查询字段属性
     */
    private Map<String, Object> customFieldMap = new HashMap<String, Object>();
 
    public int getSkip() {
        return skip;
    }
 
    public void setSkip(int skip) {
        this.skip = skip;
    }
 
    public int getLimit() {
        return limit;
    }
 
    public void setLimit(int limit) {
        this.limit = limit;
    }
 
    public Map<String, Object> getSort() {
        return sort;
    }
 
    public void setSort(Map<String, Object> sort) {
        this.sort = sort;
    }
 
    public DBObject getSortObject() {
        if (this.sort == null) {
            return null;
        }
        DBObject dbo = new BasicDBObject();
        for (String k : sort.keySet()) {
            dbo.put(k, Integer.valueOf(sort.get(k).toString()));
        }
        return dbo;
    }
 
    public Map<String, Object> getCustomFieldMap() {
        return customFieldMap;
    }
 
    public void setCustomFieldMap(Map<String, Object> customFieldMap) {
        this.customFieldMap = customFieldMap;
    }
}