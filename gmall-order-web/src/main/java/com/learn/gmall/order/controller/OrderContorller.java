package com.learn.gmall.order.controller;

import com.learn.gmall.bean.UserInfo;
import com.learn.gmall.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/11/8 22:21
 */

@RestController
public class OrderContorller {

    UserService userService;

    @GetMapping("trade")
    public UserInfo trade(Integer userId){
        UserInfo userInfo = userService.getUserInfoList().get(0);
        return userInfo;
    }
}
