package com.example.tkmapper.tk;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


@Repository
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>, ExampleMapper<T> {
}
