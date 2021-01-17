package com.xm.service;

import com.xm.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author Ming
 * @create 2020-08-13 11:37
 */
public interface UserService {

    //用户登录
    public User login(String userName, String password);

    //注册时检测用户名是否存在
    public int existUserName(@Param("userName")String userName);

    //注册时检测邮箱是否存在
    public int existEmail(@Param("email")String email);

    //用户注册，录入用户名密码邮箱
    public int registeredUserInformationEnter(@Param("userName")String userName,@Param("password")String password,@Param("email")String email);

    //找回密码时，通过用户名查询出此用户名的邮箱，判断用户输入的邮箱与数据库中的邮箱是否匹配进而是否允许用户重制密码
    public User passwordReset(@Param("userName")String userName);

    //更新密码
    public int updatePassword(@Param("password")String password,@Param("userName")String userName);

}
