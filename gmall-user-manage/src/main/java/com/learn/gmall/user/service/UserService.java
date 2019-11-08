package com.learn.gmall.user.service;


import com.learn.gmall.user.bean.UserInfo;

import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/11/8 0:02
 */
public interface UserService {

    List<UserInfo> getUserInfoList();

    void addUser(UserInfo userInfo);

    void updateUser(UserInfo userInfo);

    void updateUserByName(String name, UserInfo userInfo);

    void delUser(UserInfo userInfo);
}
