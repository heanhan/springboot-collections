/**
 * 
 */
package com.example.mongodb.service.impl;


import javax.annotation.Resource;

import com.example.mongodb.dao.IRecordDao;
import com.example.mongodb.pojo.Record;
import com.example.mongodb.service.IRecordService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Thunisoft
 *
 */
@Service
public class RecordServiceImpl implements IRecordService {

	@Resource
	private IRecordDao recordDaoImpl;

	// 保存mongo数据到mongo数据库
	@Override
	public void addMongoRecord(Record record) {
		recordDaoImpl.addMongoRecord(record);
	}

	// 删除mongo的数据
	@Override
	public void removeMongById(Long id) {
		recordDaoImpl.removeMongById(id);
	}

	// 更新mongo的数据
	@Override
	public void updateMongRecord(Record record) {
		recordDaoImpl.updateMongRecord(record);
	}

	// 根据id查询
	@Override
	public Record findRecordById(Long id) {
		return recordDaoImpl.findRecordById(id);
	}

	// 查询mongo中所有数据
	@Override
	public List<Record> findAllRecord() {
		return recordDaoImpl.findAllRecord();

	}

}
