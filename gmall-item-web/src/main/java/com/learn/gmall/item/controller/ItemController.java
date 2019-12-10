package com.learn.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.learn.gmall.bean.SkuInfo;
import com.learn.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/12/9 21:32
 */
@Controller
public class ItemController {

    @Reference
    ManageService manageService;

    @GetMapping("{skuId}.html")
    public String item(@PathVariable("skuId") String skuId, HttpServletRequest request){
        SkuInfo skuInfo = manageService.getSkuInfo(skuId);
        request.setAttribute("skuInfo", skuInfo);
        return "item";
    }
}
