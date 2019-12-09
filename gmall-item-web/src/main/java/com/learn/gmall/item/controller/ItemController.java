package com.learn.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.learn.gmall.bean.SkuInfo;
import com.learn.gmall.service.ManageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/12/9 21:32
 */
@RestController
public class ItemController {

    @Reference
    ManageService manageService;

    @GetMapping("{skuId}.html")
    public SkuInfo item(@PathVariable("skuId") String skuId){
        SkuInfo skuInfo = manageService.getSkuInfo(skuId);
        return skuInfo;
    }
}
