package com.example.mongodb.service.impl;

import com.example.mongodb.service.IPeopleService;
import com.mongodb.client.ListIndexesIterable;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author : zhaojh
 * @date : 2019-11-09
 * @function :
 */

@Service
public class PeopleServiceImpl implements IPeopleService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询索引信息
     * @return
     */
    @Override
    public String findCollectionIndexInfo() {
        ListIndexesIterable<Document> people = mongoTemplate.getCollection("people").listIndexes();
        return null;
    }
}
