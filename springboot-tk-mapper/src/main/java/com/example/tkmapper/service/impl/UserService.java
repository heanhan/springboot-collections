package com.example.tkmapper.service.impl;

import com.example.tkmapper.mapper.IUserMapper;
import com.example.tkmapper.pojo.User;
import com.example.tkmapper.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-08-07
 * @function :
 */

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserMapper userMapper;


    @Override
    public List<User> findById(){
        List<User> users = userMapper.selectAll();

        return users;
    }

}
