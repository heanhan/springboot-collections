package com.example.springbootfastdfs.service.impl;

import com.example.springbootfastdfs.dao.UserDao;
import com.example.springbootfastdfs.pojo.User;
import com.example.springbootfastdfs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-07-22
 * @function : 用户业务层
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 保存用户信息 / 更新用户信息
     * @param user 用户
     * @return 用户
     */
    @Override
    public User addUser(User user){
        return userDao.save(user);
    }


    /**
     * 查询用户信息,使用getOne, 懒加载的方式实现
     * @param id 用户的id
     * @return User
     */
    @Override
    public User findUserInfoById(int id){
        return userDao.getOne(id);
    }

    /**
     * 查询所有的用户
     * @return List<User>
     */
    @Override
    public List<User> findAllUser(){
        return userDao.findAll();
    }

    /**
     * 分页查询用户信息
     * @param pageNum 当前页
     * @param pageSize 每页显示大小
     * @return page
     */
    @Override
    public Page<User> findAllUserByPage(String pageNum, String pageSize){

        /**
         * 如果分页的数值为空，默认当前第一页，每页为10条
         */
        int page=1;
        int size=10;
        if(pageNum!=null&&!"".equals(pageNum)){
            page=1;
        }
        else if(pageSize!=null&&!"".equals(pageSize)){
            size=10;
        }

        Sort sort=Sort.by("");
        PageRequest pageRequest = PageRequest.of(page-1,size,sort);
        return userDao.findAll(pageRequest);

    }
}
