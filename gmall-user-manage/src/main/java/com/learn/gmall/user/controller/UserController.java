package com.learn.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.learn.gmall.bean.UserInfo;
import com.learn.gmall.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/11/8 0:10
 */
@RestController
public class UserController {

    @Reference
    UserService userService;

    @GetMapping("/allusers")
    public UserInfo getUserInfoById(String id){
        return userService.getUserInfoById(id);
    }
}
