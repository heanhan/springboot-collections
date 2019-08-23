package com.example.taskjobs.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICronsMapper {

    String findByCronsId(Integer cronId);
}
