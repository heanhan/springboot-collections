package com.example.jpa.dao;

import com.example.jpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User 的dao层。
 * 继承的两个接口 1、paRepository<parameter1,parameter2>
 * 参数1：映射的实体类
 * 参数2：实体类的主键的字段类型
 * 接口作用说明：
 * 2、JpaSpecificationExecutor<parameter1>
 * 参数1：映射的实体类
 * 接口作用说明：
 */

@Repository
public interface UserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    /**
     *

     *
     * 封装的一些数据库操作方法，也可以自定义。
     *     @Modifying 用在 delete、update、add 方法上; select 则不用加
     *     @Query(value = "",nativeQuery = true)
     *          value :写sql 写自定义sql 语句：
     *              参数的下标从 1 开始。
     *          nativeQuery ：是boolean 类型：
     *              true:表示：使用标准的sql 语法
     *              false(默认)： 采用jpql 语法，即通过查询的 字段是以实体为参考,不支持 * 。

     */

    /** ------------------------------------------------------------ 分隔符 ----------------------------------------------------------------------------------*/

    /**
     * 删除用户(数组)： 批量删除id
     *
     * @param userIds 用户id 的id 整型数组
     * @return int
     */
    @Modifying
    @Query(value = "delete from zjh_user where  user_id in ( ?1) ", nativeQuery = true)
//sql 语法
//  @Query(value = "delete from User where userId in ?1 ")  //jpql 语法，通过对象实体来操作，映射到数据库字段
    int removeUserBeachArray(List<Integer> userIds);//目前尚没有好的办法直接传数组，解决方案：将数组转换为 List 集合

    /**
     * 删除用户  执行自定义语句
     *
     * @param id 用户id
     * @return 返回Boolean 判断是否删除成功。
     */
    @Modifying
    @Query(value = "delete from zjh_user where user_id=?1 ", nativeQuery = true) //sql
//  @Query(value = "delete User where userId=?1 ", nativeQuery = false) //jpql
    int  removeUserById(int id);


    /**
     * 删除用户 ，批量删除 ，执行自定义sql
     * @param ids  用户id 数组
     * @return  Boolean  判断是否删除成功
     */
    @Modifying
    @Query(value = "delete from zjh_user where user_id in (?1) ",nativeQuery = true)
    int removeUserByArry(int[] ids);


    /**
     * 删除用户(list)： 批量删除id
     * @param userIds 用户id 的id 集合类型
     * @return  Boolean
     */
    @Modifying
    @Query(value = "delete from zjh_user where user_id in (?1) ",nativeQuery = true)
    int removeUserBeachList(List<Integer> userIds);


    /**
     * 通过查询用户  自定义  带有模糊查询
     * @param userName 用户名
     * @return user
     */
    @Query(value = "select * from zjh_user where  user_name like %?1% ",nativeQuery = true)
    List<User> findByUserName(String userName);

    /** ------------------------------------------------------------ 查询使用 JPA 命名规范（） ----------------------------------------------------------------------------------*/

    /**
     * 查询 ： 遵守JPA 命名规范查询 1
     * @param userName
     * @return List<User >
     */
    List<User> findByUserNameIn(List<String> userName);


    /**
     * 查询 ：  自定义 使用关键字 IN 参数为 List
     * @param userName
     * @return  List<User>
     */
    @Query(value = "from User where userName in (?1) ")  //使用jpqa  语法  补充：in 后面的括号可以加，也可以不加
    List<User> findByUserNameRange(List<String> userName);
}
