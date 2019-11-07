package com.learn.gmall.user.controller;

import com.learn.gmall.user.bean.UmsMember;
import com.learn.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/11/8 0:10
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/allusers")
    public List<UmsMember> getAllUsers(){
        return userService.getUserInfoList();
    }
}
