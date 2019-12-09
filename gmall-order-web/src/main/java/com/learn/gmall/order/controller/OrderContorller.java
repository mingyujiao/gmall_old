package com.learn.gmall.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.learn.gmall.bean.UserInfo;
import com.learn.gmall.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/11/8 22:21
 */

@RestController
public class OrderContorller {

    @Reference
    UserService userService;

    @GetMapping("trade")
    public UserInfo trade(@RequestParam("userId") String userId) {
        UserInfo userInfo = userService.getUserInfoById(userId);
        return userInfo;
    }
}
