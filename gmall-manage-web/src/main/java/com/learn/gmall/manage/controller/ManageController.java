package com.learn.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.learn.gmall.bean.*;
import com.learn.gmall.service.ManageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/11/10 23:52
 */
@RestController
// 解决跨域问题
@CrossOrigin
public class ManageController {

    @Reference
    ManageService manageService;

    @PostMapping("getBaseCatalog1")
    public List<PmsBaseCatalog1> getBaseCatalog1(){

        List<PmsBaseCatalog1> pmsBaseCatalog1s = manageService.getPmsBaseCatalog1();

        return pmsBaseCatalog1s;
    }

    @PostMapping("getBaseCatalog2")
    public List<PmsBaseCatalog2> getBaseCatalog2(String catalog1Id){

        List<PmsBaseCatalog2> pmsBaseCatalog2 = manageService.getPmsBaseCatalog2(catalog1Id);

        return pmsBaseCatalog2;
    }

    @PostMapping("getBaseCatalog3")
    public List<PmsBaseCatalog3> getBaseCatalog3(String catalog2Id){

        List<PmsBaseCatalog3> pmsBaseCatalog3 = manageService.getPmsBaseCatalog3(catalog2Id);

        return pmsBaseCatalog3;
    }

    @PostMapping("getAttrInfoList")
    public List<PmsBaseAttrInfo> getPmsBaseAttrInfoList(String catalog3Id){

        List<PmsBaseAttrInfo> attrInfos = manageService.getPmsBaseAttrInfo(catalog3Id);

        return attrInfos;
    }

    @PostMapping("saveAttrInfo")
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){

        manageService.saveAttrInfo(pmsBaseAttrInfo);

        return "success";
    }

    @PostMapping("getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList (String atrrId){

        PmsBaseAttrInfo pmsBaseInfo = manageService.getPmsBaseInfo(atrrId);

        return pmsBaseInfo.getAttrValueList();
    }

    @PostMapping("delAttrValue")
    public String delAttrValue(@RequestBody PmsBaseAttrValue attrValue){

        manageService.delPmsBaseAttrValue(attrValue);

        return "success";
    }
}
