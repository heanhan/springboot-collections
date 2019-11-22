package com.example.aop.service.impl;

import com.example.aop.entity.pojo.User;
import com.example.aop.mapper.IUserMapper;
import com.example.aop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : zhaojh
 * @date : 2019-11-22
 * @function :
 */

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    /**
     * 添加用户
     */
    @Override
    public int addUserInfo(User user){
        int i = userMapper.addUserInfo(user);
        return  i;
    }



}
