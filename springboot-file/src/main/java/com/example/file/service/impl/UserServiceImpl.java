package com.example.file.service.impl;

import com.example.file.dao.UserDao;
import com.example.file.pojo.User;
import com.example.file.service.UserService;
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
