package com.example.aop.mapper;

import com.example.aop.entity.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper {

    /**
     * 添加用户
     * @return
     */
    int addUserInfo(User user);

}
