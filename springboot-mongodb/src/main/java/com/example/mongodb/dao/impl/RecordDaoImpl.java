/**
 * 
 */
package com.example.mongodb.dao.impl;


import javax.annotation.Resource;

import com.example.mongodb.dao.IRecordDao;
import com.example.mongodb.pojo.Record;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Thunisoft
 *
 */
@Service
public class RecordDaoImpl implements IRecordDao {
	@Resource
	private MongoTemplate mongoTemplate;

	// 保存mongo数据到mongo数据库
	@Override
	public void addMongoRecord(Record record) {
		mongoTemplate.save(record);
	}

	// 删除mongo的数据
	@Override
	public void removeMongById(Long id) {
		mongoTemplate.remove(id);
	}

	// 更新mongo的数据
	@Override
	public void updateMongRecord(Record record) {
		Query query = new Query(Criteria.where("id").is(record.getId()));
		Update update = new Update();
		update.set("title", record.getTitle());
		update.set("description", record.getDescription());
		update.set("by", record.getBy());
		update.set("url", record.getUrl());
		mongoTemplate.updateFirst(query, update, Record.class);
	}

	// 根据id查询
	@Override
	public Record findRecordById(Long id) {
		Query query = new Query(Criteria.where("id").is(id));
		Record record = mongoTemplate.findOne(query, Record.class);
		return record;
	}

	// 查询mongo中所有数据
	@Override
	public List<Record> findAllRecord() {
		Query query = new Query();
		List<Record> recordList = mongoTemplate.find(query, Record.class);
		return recordList;
	}

}
