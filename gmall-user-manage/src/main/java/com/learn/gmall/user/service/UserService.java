package com.learn.gmall.user.service;


import com.learn.gmall.user.bean.UmsMember;

import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/11/8 0:02
 */
public interface UserService {

    List<UmsMember> getUserInfoList();

    void addUser(UmsMember userInfo);

    void updateUser(UmsMember userInfo);

    void updateUserByName(String name, UmsMember userInfo);

    void delUser(UmsMember userInfo);
}
