/**
 * 
 */
package com.example.mongodb.utils;
import java.util.Map;

/**
 * @author Thunisoft
 *
 */
public class MongoDBUpdate extends MongoDBEntity {
 
    /**
     * where查询Map
     */
    private Map<String, Object> whereMap;
 
    /**
     * value查询Map
     */
    private Map<String, Object> valueMap;
 
    public Map<String, Object> getWhereMap() {
        return whereMap;
    }
 
    public void setWhereMap(Map<String, Object> whereMap) {
        this.whereMap = whereMap;
    }
 
    public Map<String, Object> getValueMap() {
        return valueMap;
    }
 
    public void setValueMap(Map<String, Object> valueMap) {
        this.valueMap = valueMap;
    }
}