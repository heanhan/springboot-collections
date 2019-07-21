package com.example.jpa.service.impl;

import com.example.jpa.dao.UserDao;
import com.example.jpa.pojo.User;
import com.example.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import javax.xml.crypto.Data;
import java.util.*;

/**
 * @author : zhaojh
 * @date : 2019-07-20
 * @function :
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    /**----------------------------------------------------------------- 添加  -----------------------------------------------------------------------------*/
    /**
     * 添加用户 单个用户的插入
     * @param user 用户
     * @return User 对象
     */
    @Override
    public User addUser(User user){
        return userDao.save(user);
    }


    /**
     * 添加用户  批量添加
     * @param userList  用户集合
     * @return  List<User>
     */
    @Override
    public List<User> addUserList(List<User> userList){
        return userDao.saveAll(userList);
    }


    /**----------------------------------------------------------------- 删除  -----------------------------------------------------------------------------*/

    /**   -- 删除jpa 默认的删除方法不带有返回值，所有自定义一部分删除方法 --       */
    /**
     * 删除用户： 根据id 删除单个用户， 缺点无法判断是否删除成功
     * @param userId  用户id
     * @return  void
     */
    @Override
    public void removeUser(int userId){
        userDao.deleteById(userId);
    }


    /**
     * 删除用户(数组)： 批量删除id
     * @param userIds 用户id 的id 整型数组
     * @return int
     */
    @Override
    public int removeUserBeachArray(Integer[] userIds){
        return userDao.removeUserBeachArray(Arrays.asList(userIds));
    }


    /**
     * 删除所有,不带有任何条件，全部删除
     */
    @Override
    public void removeAllUser(){
        userDao.deleteAll();
    }


    /**
     * 删除用户  通过user实体
     * @param user 用户
     */
    @Override
    public void removeUserByPojo(User user){
        userDao.delete(user);
    }


    /**
     *删除用户 ，批量删除
     * @param users  用户List 集合
     */
    @Override
    public void removeByUserList(List<User> users){
        userDao.deleteInBatch(users);
    }


    /**
     * 删除用户  执行自定义语句
     * @param id  用户id
     * @return  返回int 判断是否删除成功。
     */
    @Override
    public int  removeUserById(int id){
        return userDao.removeUserById(id);
    }


    /**
     * 删除用户 ，批量删除 ，执行自定义sql
     * @param ids  用户id 数组
     * @return  int  判断是否删除成功
     */
    @Override
    public int removeUserByArry(int[] ids){
        return userDao.removeUserByArry(ids);

    }


    /**
     * 删除用户(list)： 批量删除id
     * @param userIds 用户id 的id 集合类型
     * @return  Boolean
     */
    @Override
    public int removeUserBeachList(List<Integer> userIds){
        return userDao.removeUserBeachList(userIds);
    }

    /**----------------------------------------------------------------- 更新  -----------------------------------------------------------------------------*/

    /**
     * 更新用户信息 : 单个更新
     * @param user  用户信息
     * @return user
     */
    @Override
    public User updateUserInfo(User user){
        return userDao.save(user);
    }


    /**
     * 更新用户信息
     * @param userList  批量用户信息
     * @return  int 判断更新是否成功
     */
    @Override
    public List<User> updateUserInfoBeatch(List<User> userList){
        return userDao.saveAll(userList);
    }

    /**----------------------------------------------------------------- 查询  -----------------------------------------------------------------------------*/

    /**
     *  findOne()： 立即加载
     *  getOne() :懒加载
     */

    /**
     *查询用户：根据id查询
     * @param userId  用户id
     * @return
     */
    @Override
    public User findUserInfo(int userId){
        Optional<User> optionUser = userDao.findById(userId);
        /**
         * Optinal jdk 8 特性  可以避免空指针
         *  重要的方法
         *          get(): 获取当前对象
         *          isPresent() 如果值存在返回true，否则返回false。
         *          empty() 返回一个空的 Optional实例。
         *          of(T value) 为非null的值创建一个Optional。
         *          ofNullable(T value) 为指定的值创建一个Optional，如果指定的值为null，则返回一个空的Optional。
         *          orElse(T other) 如果有值则将其返回，否则返回指定的其它值other。
         */
        User user = optionUser.get();
        return user;
    }


    /**
     * 通过查询用户  自定义  带有模糊查询
     * @param userName 用户名
     * @return user
     */
    @Override
    public List<User> findByUserName(String userName){
        return userDao.findByUserName(userName);
    }


    /**
     * 查询所有的用户信息
     * @return 用户List 集合
     */
    @Override
    public List<User> findAllUser(){
        return userDao.findAll();
    }


    /**
     * 查询所有用户： 带分页,不携带任何用户信息、并进行排序
     * @param pageRequest 封装的分页信息
     * @return  分页对象
     */
    @Override
    public Page<User> findAllUser(PageRequest pageRequest){
        return userDao.findAll(pageRequest);
    }


    /**
     * 查询所有用户 ： 带分页、携带用户名查询、模糊查询
     * @param userName  用户名
     * @param pageRequest  封装的分页信息
     * @return page对象
     */
    @Override
    public Page<User> findAllUserByName(String userName,PageRequest pageRequest){
        //构建条件 使用 Specification 对象
        Specification<User> specUser=new Specification<User>() {

            /**
             *
             * @param root  拿到对象的所有属性信息
             * @param criteriaQuery  查询执行，一般用不到
             * @param criteriaBuilder 构建条件
             * @return
             */

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                /**
                 * root 拿到当前对象的所有信息
                 * Path 包装 从实体中获取的属性
                 * Predicate 为属赋值的对象
                 */
                //1、从实体中获取属性
                Path<User> userNameInfo = root.get("userName");//第一步 从实体中拿到属性，为下一步属性赋值

                //2、为属性赋值
//                Predicate predicate = criteriaBuilder.equal(userNameInfo.as(String.class), userName);// equal 是精确查询
                Predicate predicate = criteriaBuilder.like(userNameInfo.as(String.class),"%"+userName+"%");// 模糊查询
                return predicate;
            }
        };

        Page<User> userPage = userDao.findAll(specUser, pageRequest); return userPage;
    }


    /**
     *
     * @param param 查询所有用户，动态参数、模糊匹配、分页
     * @param pageRequest  分页信息
     * @return 分页实体
     */
    @Override
    public Page<User> findAllUserByDynamicCondition(Map<String,String> param, PageRequest pageRequest){

        //取出map 中参数
        String userId = param.get("userId");
        String userName = param.get("userName");
        String gender = param.get("gender");
        String startTime = param.get("startTime");//开始时间
        String endTime = param.get("endTime");//结束时间

        Specification<User> spec=new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();//创建一个Prddicate 添加封装集合

                if(userId!=null&&"".equals(userId)){
                    Path<User> userId1 = root.get("userId");
                    predicates.add(criteriaBuilder.equal(userId1.as(Integer.class), userId));
                }
                if(userName!=null&&"".equals(userName)){
                    Path<User> userName1 = root.get("userName");
                    predicates.add(criteriaBuilder.like(userName1.as(String.class),"%"+userName+"%"));

                }
                //如果开始时间或者结束时间不为空
//                if( ( startTime!=null&&"".equals(startTime) ) || ( endTime!=null&&"".equals(endTime) ) ){
//                    Path<User> createTime=root.get("createTime");
//                    criteriaBuilder.between(createTime.as(Data.class),)
//                }
//                Predicate and = criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));// 将之前封装的条件封在一起。
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Page<User> userPage = userDao.findAll(spec, pageRequest);
        return userPage;
    }


    /**
     * 查询 ： 遵守JPA 命名规范查询
     * @param userName
     * @return List<User>
     */
    @Override
    public List<User> findByUserNameIn(List<String> userName){
        return userDao.findByUserNameIn(userName);
    }


    /**
     * 查询 ：  自定义 使用关键字 IN 参数为 List
     * @param userName
     * @return  List<User>
     */
    @Override
    public List<User> findByUserNameRange(List<String> userName){
        return userDao.findByUserNameRange(userName);
    }


}
