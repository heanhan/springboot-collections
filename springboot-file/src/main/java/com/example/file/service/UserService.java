package com.example.file.service;

import com.example.file.pojo.User;

public interface UserService {

    /**
     * 添加用户信息
     * @param user 用户实体
     * @return 用户
     */
    User addUser(User user);
}
