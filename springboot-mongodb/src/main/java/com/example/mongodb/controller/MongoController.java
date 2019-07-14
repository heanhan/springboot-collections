/**
 * 
 */
package com.example.mongodb.controller;


import com.example.mongodb.pojo.Record;
import com.example.mongodb.service.IRecordService;
import com.example.mongodb.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @author Thunisoft
 *
 */

@RestController
@EnableSwagger2
@Api(value = "Test mongo", description = "springboot框架下的mongo数据库的使用 demo", tags = { "mongo-springboot框架的结合使用 tags" })
public class MongoController {
	@Autowired
	private IRecordService recordServiceImpl;

	// 开关
	private int intFlag = -1;
	private boolean flag = false;

	// 在mongo数据库中添加数据
	@PostMapping(value = "/addMongoRecord")
	@ApiOperation(value = "向Mongo数据库中添加", notes = "notes-向Mongo数据库中添加")
	@ApiImplicitParams(value = { @ApiImplicitParam(paramType = "query", name = "id", value = "编号", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "title", value = "标题", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "description", value = "描述", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "by", value = "出处", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "url", value = "联系方式", dataType = "String") })
	public void addMongoRecord(@ModelAttribute Record record) {
		System.out.println("接收参数：" + record);
		recordServiceImpl.addMongoRecord(record);
		ResultUtil.success("添加成功");
	}

	// 删除mongo数据库中的对应key的某条数据
	@DeleteMapping(value = "/removeMongById")
	@ApiOperation(value = "根据id删除mongo中的记录", notes = "notes-向Mongo数据库中删除数据")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(paramType = "query", name = "id", value = "编号", dataType = "String"), })
	public void removeMongById(int id) {
		System.out.println("接收参数：" + id);
		recordServiceImpl.removeMongById((long) id);
		ResultUtil.success("删除成功");
	}

	// 更新mongo数据库中的字段
	@PutMapping(value = "/updateMongRecord")
	@ApiOperation(value = "更新Mongo数据库中数据", notes = "notes-更新Mongo数据库中数据")
	@ApiImplicitParams(value = { @ApiImplicitParam(paramType = "query", name = "id", value = "编号", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "title", value = "标题", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "description", value = "描述", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "by", value = "出处", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "url", value = "联系方式", dataType = "String") })
	public void updateMongRecord(@ModelAttribute Record record) {
		System.out.println("接收参数：" + record);
		recordServiceImpl.updateMongRecord(record);
		ResultUtil.success("更新成功");
	}

	// 根据id查询mongo中的单条记录
	@GetMapping(value = "/findRecordById")
	@ApiOperation(value = "根据id删除mongo中的记录", notes = "notes-向Mongo数据库中删除数据")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(paramType = "query", name = "id", value = "编号", dataType = "String")
	})
	public Record findRecordById(int id) {

		Record record = recordServiceImpl.findRecordById((long) id);
		System.out.println(JSONObject.toJSONString(record));
		return record;
	}

	// 查询所有的数据
	@GetMapping(value = "/findAllRecord")
	@ApiOperation(value = "查询mongo中的所有记录", notes = "notes-查询mongo中的所有记录")
	public List<Record> findAllRecord() {
		List<Record> recordList = recordServiceImpl.findAllRecord();
		System.out.println("获取的list集合" + recordList);
		return recordList;
	}

}
