package com.example.files.service.impl;

import com.example.files.dao.UserDao;
import com.example.files.pojo.User;
import com.example.files.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserDao userDao;


    /**
     * 添加用户信息
     * @param user 用户实体
     * @return
     */
    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }
}
