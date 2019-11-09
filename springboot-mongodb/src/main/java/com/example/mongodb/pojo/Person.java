package com.example.mongodb.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author : zhaojh
 * @date : 2019-11-09
 * @function : mongo 使用索引
 *
 * Spring Data Mongo 的索引穿件比较方便 直接添加注解即可
 *   方法：要给某个字段添加索引  直接添加注解 @Indexed 即可。里面有一些对应的参数
 *   如创建唯一索引的参数使用的就是 unique=true,以后台的方式创建索引的参数是 background = true
 *   然后组合索引的创建 要在类的上面添加注解 @CompoundIndexes 参数是 @CompoundIndex 的注解数组，可以传递多个
 *   该注解中的参数有  name 标识索引的名称，def 表示组合索引的字段和索引存储升序（1），或者降序（-1）
 */

@Document
//@CompoundIndexes(
//        @CompoundIndex(name = "city_region_idx",def ="{'city':1,'region':-1}" ) //使用联合索引
//)
@Data
public class Person {

    @Id
    private String id;//主键

    @Field(value = "name")
    @Indexed(unique = true) //创建唯一索引
    private String name;//名称

    @Field(value = "age")
    @Indexed(background = true)
    private int age;//年龄

    @Field(value = "city")
    private String city;//城市

    @Field(value = "region")
    private String region;//地域
}
