package com.learn.gmall.user.service.impl;

import com.learn.gmall.user.bean.UserInfo;
import com.learn.gmall.user.mapper.UserMapper;
import com.learn.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/11/8 0:05
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserInfo> getUserInfoList() {
        List<UserInfo> userInfoList = userMapper.selectAll();
        return userInfoList;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userMapper.insert(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        userMapper.updateByPrimaryKey(userInfo);
    }

    @Override
    public void updateUserByName(String name, UserInfo userInfo) {

    }

    @Override
    public void delUser(UserInfo userInfo) {

    }
}
