package com.example.springbootfastdfs.service;


import com.example.springbootfastdfs.pojo.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    /**
     * 保存用户信息
     * @param user 用户
     * @return 用户
     */
    User addUser(User user);

    /**
     * 查询用户信息
     * @param id 用户的id
     * @return User
     */
    User findUserInfoById(int id);

    /**
     * 查询所有的用户
     * @return List<User>
     */
    List<User> findAllUser();

    /**
     * 分页查询用户信息
     * @param pageNum 当前页
     * @param pageSize 每页显示大小
     * @return page
     */
    Page<User> findAllUserByPage(String pageNum,String pageSize);
}
