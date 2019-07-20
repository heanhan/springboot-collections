package com.example.jpa.service;


import com.example.jpa.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * 用户接口
 */

public interface UserService {


    /**
     * 添加用户 单个用户的插入
     * @param user 用户
     * @return User 对象
     */
    User addUser(User user);


    /**
     * 添加用户  批量添加
     * @param userList  用户集合
     * @return  List<User>
     */
    List<User> addUserList(List<User> userList);


    /**
     * 删除用户： 根据id 删除单个用户， 缺点无法判断是否删除成功
     * @param userId  用户id
     * @return  void
     */
    void removeUser(int userId);


    /**
     * 删除用户(数组)： 批量删除id
     * @param userIds 用户id 的id 整型数组
     * @return int
     */
    int removeUserBeachArray(int[] userIds);


    /**
     * 删除所有
     */
    void removeAllUser();


    /**
     * 删除用户  通过user实体
     * @param user
     */
    void removeUserByPojo(User user);


    /**
     *删除用户 ，批量删除
     * @param users  用户List 集合
     */
    void removeByUserList(List<User> users);


    /**
     * 删除用户  执行自定义语句
     * @param id  用户id
     * @return  返回Boolean 判断是否删除成功。
     */
    int removeUserById(int id);


    /**
     * 删除用户 ，批量删除 ，执行自定义sql
     * @param ids  用户id 数组
     * @return  Boolean  判断是否删除成功
     */
    int removeUserByArry(int[] ids);


    /**
     * 删除用户(list)： 批量删除id
     * @param userIds 用户id 的id 集合类型
     * @return  Boolean
     */
    int removeUserBeachList(List<Integer> userIds);


    /**
     * 更新用户信息 : 单个更新
     * @param user  用户信息
     * @return user
     */
    User updateUserInfo(User user);


    /**
     * 更新用户信息
     * @param userList  批量用户信息
     * @return  int 判断更新是否成功
     */
    List<User> updateUserInfoBeatch(List<User> userList);


    /**
     *查询用户：根据id查询
     * @param userId  用户id
     * @return
     */
    User findUserInfo(int userId);


    /**
     * 通过查询用户  自定义  带有模糊查询
     * @param userName 用户名
     * @return user
     */
    List<User> findByUserName(String userName);


    /**
     * 查询所有的用户信息
     * @return 用户List 集合
     */
    List<User> findAllUser();


    /**
     * 查询所有用户： 带分页,不携带任何用户信息、并进行排序
     * @param pageRequest 封装的分页信息
     * @return  分页对象
     */
    Page<User> findAllUser(PageRequest pageRequest);


    /**
     * 查询所有用户 ： 带分页、携带用户名查询、模糊查询
     * @param userName  用户名
     * @param pageRequest  封装的分页信息
     * @return page对象
     */
    Page<User> findAllUserByName(String userName,PageRequest pageRequest);


    /**
     *
     * @param param 查询所有用户，动态参数、模糊匹配、分页
     * @param pageRequest  分页信息
     * @return 分页实体
     */
    Page<User> findAllUserByDynamicCondition(Map<String,String> param,PageRequest pageRequest);


    /**
     * 查询 ： 遵守JPA 命名规范查询
     * @param userName
     * @return
     */
    List<User> findByUserNameIn(List<String> userName);


    /**
     * 查询 ：  自定义 使用关键字 IN 参数为 List
     * @param userName
     * @return  List<User>
     */
    List<User> findByUserNameRange(List<String> userName);

}
