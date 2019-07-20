package com.example.jpa.controller;

import com.example.common.model.Result;
import com.example.common.model.StatusCode;
import com.example.jpa.pojo.User;
import com.example.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author : zhaojh
 * @date : 2019-07-20
 * @function :
 */

@RestController
@RequestMapping(value = "/jpa")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 添加用户 单个用户的插入
     *
     * @param user 用户
     * @return Result
     */
    @PostMapping(value = "/addUser")
    public Result addUser(User user) {
        User userInfo = userService.addUser(user);
        if (userInfo.getUserId() != null) {
            return new Result(true,StatusCode.OK," is success ！");
        } else {
            return new Result(false,StatusCode.ERROR," is failure ！");
        }
    }


    /**
     * 添加用户  批量添加
     * @return Result
     */
    @PostMapping(value="/addUserList")
    public Result addUserList() {
        //
        Random rand = new Random();
        List<User> userList = new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            User user =new User();
            user.setUserName("测试人"+i);//姓名
            user.setPassword("123456");//密码
            user.setGender((rand.nextInt(2)-1)+""); //0 代表 男，1 代表女。
            user.setHobby("爱好"+i);//爱好
            user.setDescInfo("这个一个自我介绍,我是测试人"+i);
            user.setCreateTime(new Date());//创建时间
            userList.add(user);

        }
        List<User> users = userService.addUserList(userList);
        if(users.size()>0){
            return new Result(true,StatusCode.OK," is success ！");
        }
        return new Result(false,StatusCode.ERROR," is failure ！");
    }

    /**
     * 删除用户： 根据id 删除单个用户， 缺点无法判断是否删除成功
     * @param userId  用户id
     * @return Result
     */
    @DeleteMapping(value = "/removeUser")
    public Result removeUser(int userId){
        userService.removeUser(userId);
        return new Result(true,StatusCode.OK," is success ！");
    }


    /**
     * 删除用户(数组)： 批量删除id
     * @param userIds 用户id 的id 整型数组
     * @return Result
     */
    @DeleteMapping(value="/removeUserBeachArray")
    public Result removeUserBeachArray(int[] userIds){
        int i = userService.removeUserBeachArray(userIds);
        if(i>0){
            return new Result(true,StatusCode.OK," is success ！");
        }
        return new Result(false,StatusCode.ERROR," is failure ！");
    }

    /**
     * 删除所有
     */
    @DeleteMapping(value="/removeAllUser")
    public Result removeAllUser(){
        userService.removeAllUser();
        return new Result(true,StatusCode.OK," is success ！");
    }


    /**
     * 删除用户  通过user实体
     * @param user
     * @return  Result
     */
    @DeleteMapping(value="/removeUserByPojo")
    public Result removeUserByPojo(User user){
        userService.removeUserByPojo(user);
        return new Result(true,StatusCode.OK," is success ！");
    }


    /**
     *删除用户 ，批量删除
     * @param users  用户List 集合
     * @return Result
     */
    @DeleteMapping(value="/removeByUserList")
    public Result removeByUserList(List<User> users){
        userService.removeByUserList(users);
        return new Result(true,StatusCode.OK," is success ！");
    }


    /**
     * 删除用户  执行自定义语句
     * @param id  用户id
     * @return 返回Boolean 判断是否删除成功。
     */
    @DeleteMapping(value="/removeUserById")
    public Result removeUserById(int id){
        int i = userService.removeUserById(id);
        if(i>0){
            return new Result(true,StatusCode.OK," is success ！");
        }
        return new Result(true,StatusCode.ERROR," is failure ！");
    }


    /**
     * 删除用户 ，批量删除 ，执行自定义sql
     * @param ids  用户id 数组
     * @return Result
     */
    @DeleteMapping(value="/removeUserByArry")
    public Result removeUserByArry(int[] ids){
        int i = userService.removeUserByArry(ids);
        if(i>0){
            return new Result(true,StatusCode.OK," is success ！");
        }
        return new Result(true,StatusCode.ERROR," is failure ！");
    }


    /**
     * 删除用户(list)： 批量删除id
     * @param userIds 用户id 的id 集合类型
     * @return Result
     */
    @DeleteMapping(value = "/removeUserBeachList")
    public Result removeUserBeachList(List<Integer> userIds){
        int i = userService.removeUserBeachList(userIds);
        if(i>0){
            return new Result(true,StatusCode.OK," is success ！");
        }
        return new Result(true,StatusCode.ERROR," is failure ！");
    }


    /**
     * 更新用户信息 : 单个更新
     * @param user  用户信息
     * @return Result
     */
    @DeleteMapping(value = "/updateUserInfo")
    public Result updateUserInfo(User user){
        User user1 = userService.updateUserInfo(user);
        if(user1.getUserId()!=null){
            return new Result(true,StatusCode.OK," is success ！");
        }
        return new Result(true,StatusCode.ERROR," is failure ！");
    }


    /**
     * 更新用户信息
     * @param userList  批量用户信息
     * @return Result
     */
    @DeleteMapping(value="/updateUserInfoBeatch")
    public Result updateUserInfoBeatch(List<User> userList){
        List<User> users = userService.updateUserInfoBeatch(userList);
        if(users.size()>0){
            return new Result(true,StatusCode.OK," is success ！");
        }
        return new Result(true,StatusCode.ERROR," is failure ！");
    }


    /**
     *查询用户：根据id查询
     * @param userId  用户id
     * @return  Result
     */
    @GetMapping(value = "/findUserInfo")
    public Result findUserInfo(int userId){
        User userInfo = userService.findUserInfo(userId);
        if(userInfo.getUserId()!=null){
            return new Result(true,StatusCode.OK," is success !",userInfo);
        }
        return new Result(true,StatusCode.ERROR," is failure ！");
    }


    /**
     * 通过查询用户  自定义  带有模糊查询
     * @param userName 用户名
     * @return  Result
     */
    @GetMapping(value="/findByUserName")
    public Result findByUserName(String userName){
        List<User> byUserNameList = userService.findByUserName(userName);
        if(byUserNameList.size()>0){
            return new Result(true,StatusCode.OK," is success !",byUserNameList);
        }
        return new Result(true,StatusCode.ERROR," is failure ！");
    }


    /**
     * 查询所有的用户信息
     * @return  Result
     */
    @GetMapping(value = "/findAllUser")
    public Result findAllUser(){
        List<User> allUser = userService.findAllUser();
        if(allUser.size()>0){
            return new Result(true,StatusCode.OK," is success !",allUser);
        }
        return new Result(true,StatusCode.ERROR," is failure ！");
    }


    /**
     * 查询所有用户： 带分页,不携带任何用户信息、并进行排序
     * @param pageNum 当前页
     * @param pageSize 分页大小
     * @return Result
     */
    @GetMapping(value="/findAllUser")
    public Result findAllUser(String pageNum,String pageSize){
        PageRequest pageRequest =PageRequest.of(Integer.parseInt(pageNum)-1,Integer.parseInt(pageSize));
        Page<User> allUser = userService.findAllUser(pageRequest);
        return new Result(true,StatusCode.OK," is success ！",allUser);
    }


    /**
     * 查询所有用户 ： 带分页、携带用户名查询、模糊查询
     * @param userName  用户名
     * @param pageNum 当前页
     * @param pageSize 分页大小
     * @return Result
     */
    @GetMapping(value="/findAllUserByName")
    public Result findAllUserByName(String userName,String pageNum,String pageSize){
        PageRequest pageRequest =PageRequest.of(Integer.parseInt(pageNum)-1,Integer.parseInt(pageSize));
        Page<User> allUser = userService.findAllUserByName(userName, pageRequest);
        return new Result(true,StatusCode.OK," is success ！",allUser);
    }


    /**
     *
     * @param param 查询所有用户，动态参数、模糊匹配、分页
     * @return Result
     */
    @GetMapping(value="/findAllUserByDynamicCondition")
    public Result findAllUserByDynamicCondition(Map<String,String> param){
        String pageNum = param.get("pageNum");
        String pageSize = param.get("pageSize");
        PageRequest pageRequest =PageRequest.of(Integer.parseInt(pageNum)-1,Integer.parseInt(pageSize));
        Page<User> allUserByDynamicCondition = userService.findAllUserByDynamicCondition(param, pageRequest);
        return new Result(true,StatusCode.OK," is success ！",allUserByDynamicCondition);
    }


    /**
     * 查询 ： 遵守JPA 命名规范查询
     * @param userName
     * @return Result
     */
    @GetMapping(value="/byUserNameIn")
    public Result findByUserNameIn(List<String> userName){
        List<User> byUserNameIn = userService.findByUserNameIn(userName);
        if(byUserNameIn.size()>0){
            return new Result(true,StatusCode.OK," is success ！",byUserNameIn);
        }
        return new Result(false,StatusCode.ERROR," is failure !");
    }


    /**
     * 查询 ：  自定义 使用关键字 IN 参数为 List
     * @param userName
     * @return Result
     */
    @GetMapping(value = "/findByUserNameRange")
    public Result findByUserNameRange(List<String> userName){
        List<User> byUserNameRange = userService.findByUserNameRange(userName);
        if(byUserNameRange.size()>0){
            return new Result(true,StatusCode.OK," is success ！",byUserNameRange);
        }
        return new Result(false,StatusCode.ERROR," is failure !");
    }


}
