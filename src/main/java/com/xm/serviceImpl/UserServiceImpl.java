package com.xm.serviceImpl;

import com.xm.bean.User;
import com.xm.dao.UserMapper;
import com.xm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ming
 * @create 2020-08-13 11:38
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //用户登录
    @Override
    public User login(String userName, String password) {
        return userMapper.login(userName,password);
    }

    //注册时检测用户名是否存在
    @Override
    public int existUserName(String userName) {
        return userMapper.existUserName(userName);
    }

    //注册时检测邮箱是否存在
    @Override
    public int existEmail(String email) {
        return userMapper.existEmail(email);
    }

    //用户注册，录入用户名密码邮箱
    @Override
    public int registeredUserInformationEnter(String userName, String password, String email) {
        return userMapper.registeredUserInformationEnter(userName,password,email);
    }

    //找回密码时，通过用户名查询出此用户名的邮箱，判断用户输入的邮箱与数据库中的邮箱是否匹配进而是否允许用户重制密码
    @Override
    public User passwordReset(String userName) {
        return userMapper.passwordReset(userName);
    }

    //更新密码
    @Override
    public int updatePassword(String password,String userName) {
        return userMapper.updatePassword(password,userName);
    }


}
