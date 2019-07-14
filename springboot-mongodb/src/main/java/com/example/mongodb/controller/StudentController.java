package com.example.mongodb.controller;

import com.example.mongodb.pojo.Student;
import com.example.mongodb.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Thunisoft
 *
 */
@RestController
@EnableSwagger2
@Api(value = "Test mongoDB ", description = "springboot-mongodb", tags = { "Student-springboot框架的结合使用 tags" })
public class StudentController {
	@Autowired
	private IStudentService studentServiceImpl;

	// 插入student
	@PostMapping("/addStudetnInfo")
	@ApiOperation(value = "添加学生数据", notes = "功能模块-添加学生数据")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(paramType = "query", name = "studentId", value = "学号", dataType = "int"),
			@ApiImplicitParam(paramType = "query", name = "name", value = "姓名", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "sex", value = "性别", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "age", value = "年龄", dataType = "int"),
			@ApiImplicitParam(paramType = "query", name = "hight", value = "身高", dataType = "double"),
			@ApiImplicitParam(paramType = "query", name = "classGrade", value = "班级", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "className", value = "班级", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "score", value = "分数", dataType = "double"),
			@ApiImplicitParam(paramType = "query", name = "birthday", value = "出生日期", dataType = "Date") })
	public void addStudentInfo(@ModelAttribute Student student) {
		studentServiceImpl.addStudentInfo(student);
	}

	// 查询 按照日期进行查询
	@PostMapping("/findStudentByBirthday")
	@ApiOperation(value = "按照日期查询学生记录", notes = "功能模块-按照日期查询学生记录")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(paramType = "query", name = "birthday", value = "出生日期", dataType = "Date"), })
	public Student findStudentByBirthday(@ModelAttribute Student student) {
		Student students = studentServiceImpl.findStudentByBirthday(student.getBirthday());
		return students;
	}

	// 按照时间段查询记录。
	@PostMapping("/findStudentByBirthdayBetween")
	@ApiOperation(value = "按照时间段查询记录", notes = "功能模块-按照时间段查询记录")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(paramType = "query", name = "startDate", value = "开始日期", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "endDate", value = "结束日期", dataType = "String") })
	public List<Student> findStudentByBirthdayBetween(String startDate, String endDate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startparse = sdf.parse(startDate);
		Date endparse = sdf.parse(endDate);
		System.out.println("开始时间" + startparse);
		System.out.println("结束时间" + endparse);
		List<Student> StudentList = studentServiceImpl.findStudentByBirthdayBetween(startparse, endparse);
		return StudentList;

	}

	// 动态多条件查询
	@PostMapping(value = "/DynamicConditionFindStudent")
	@ApiOperation(value = "动态多条件查询", notes = "功能模块-动态多条件查询")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(paramType = "query", name = "studentId", value = "学号", dataType = "int"),
			@ApiImplicitParam(paramType = "query", name = "name", value = "姓名", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "sex", value = "性别", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "age", value = "年龄", dataType = "int"),
			@ApiImplicitParam(paramType = "query", name = "hight", value = "身高", dataType = "double"),
			@ApiImplicitParam(paramType = "query", name = "classGrade", value = "班级", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "className", value = "班级", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "score", value = "分数", dataType = "double"),
			@ApiImplicitParam(paramType = "query", name = "birthday", value = "出生日期", dataType = "Date") })
	public List<Student> dynamicConditionFindStudent(@ModelAttribute Student student) {
		List<Student> studentList = studentServiceImpl.dynamicConditionFindStudent(student);
		return studentList;
	}

	// 聚合函数的使用
	// 聚合- 求和sum
	@PostMapping(value = "/findStudentSumByCondition")
	@ApiOperation(value = "聚合- 求和sum", notes = "聚合sum- 求和sum")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(paramType = "query", name = "classname", value = "班级名称", dataType = "String", required = true),
			@ApiImplicitParam(paramType = "query", name = "classGrade", value = "班级", dataType = "String", required = true) })
	public double findStudentSumByCondition(String classname, String classgrade) {
		Map<String, Object> param = new HashMap<>();
		param.put("classname", classname);
		param.put("classgrade", classgrade);
		return studentServiceImpl.findStudentSumByCondition(param);
	}

	// 聚合- 统计count
	@PostMapping(value = "/findStudentCountByCondition")
	@ApiOperation(value = "聚合- 统计count", notes = "聚合count- 统计count")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(paramType = "query", name = "classname", value = "班级名称", dataType = "String", required = true),
			@ApiImplicitParam(paramType = "query", name = "classgrade", value = "班级", dataType = "String", required = true) })
	public long findStudentCountByCondition(String classname, String classgrade) {
		Map<String, Object> param = new HashMap<>();
		param.put("classname", classname);
		param.put("classgrade", classgrade);
		return studentServiceImpl.findStudentCountByCondition(param);
	}

}
