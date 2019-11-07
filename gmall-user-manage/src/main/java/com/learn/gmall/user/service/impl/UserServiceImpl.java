package com.learn.gmall.user.service.impl;

import com.learn.gmall.user.bean.UmsMember;
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
    public List<UmsMember> getUserInfoList() {
        List<UmsMember> userInfoList = userMapper.selectAll();
        return userInfoList;
    }

    @Override
    public void addUser(UmsMember userInfo) {
        userMapper.insert(userInfo);
    }

    @Override
    public void updateUser(UmsMember userInfo) {
        userMapper.updateByPrimaryKey(userInfo);
    }

    @Override
    public void updateUserByName(String name, UmsMember userInfo) {

    }

    @Override
    public void delUser(UmsMember userInfo) {

    }
}
