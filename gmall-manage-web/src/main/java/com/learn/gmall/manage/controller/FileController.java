package com.learn.gmall.manage.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jmy
 * @date 2019/12/3 17:21
 * @email jiaomingyu5778@gmail.com
 */
@RestController
public class FileController {

    @PostMapping("fileUpload")
    public String fileUpload(){
        return "";
    }
}
