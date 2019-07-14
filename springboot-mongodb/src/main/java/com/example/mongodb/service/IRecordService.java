/**
 * 
 */
package com.example.mongodb.service;


import com.example.mongodb.pojo.Record;

import java.util.List;

/**
 * @author Thunisoft
 *
 */
public interface IRecordService {
	// 保存数据
	public void addMongoRecord(Record demoEntity);

	// 根据id删除mongo中对应数据
	public void removeMongById(Long id);

	// 更新数据
	public void updateMongRecord(Record demoEntity);

	// 根据id 查询mongo中数据
	public Record findRecordById(Long id);

	//查询mongo中所有数据
	public List<Record> findAllRecord();

}
