/**
 * 
 */
package com.example.mongodb.dao;


import com.example.mongodb.pojo.Record;

import java.util.List;

/**
 * @author Thunisoft
 *
 */

public interface IRecordDao {
	// 保存数据
	public void addMongoRecord(Record record);

	// 根据id删除mongo中对应数据
	public void removeMongById(Long id);

	// 更新数据
	public void updateMongRecord(Record record);

	// 根据id 查询mongo中数据
	public Record findRecordById(Long id);

	// 查询mongo中所有数据
	public List<Record> findAllRecord();

}
