package com.learn.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.learn.gmall.bean.*;
import com.learn.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("getCatalog1")
    public List<BaseCatalog1> getBaseCatalog1(){
        List<BaseCatalog1> baseCatalog1 = manageService.getBaseCatalog1();

        return baseCatalog1;
    }

    @PostMapping("getCatalog2")
    public List<BaseCatalog2> getBaseCatalog2(String catalog1Id){

        List<BaseCatalog2> baseCatalog2 = manageService.getBaseCatalog2(catalog1Id);

        return baseCatalog2;
    }

    @PostMapping("getCatalog3")
    public List<BaseCatalog3> getBaseCatalog3(String catalog2Id){

        List<BaseCatalog3> baseCatalog3 = manageService.getBaseCatalog3(catalog2Id);

        return baseCatalog3;
    }

    @GetMapping("attrInfoList")
    public List<BaseAttrInfo> getBaseAttrInfoList(String catalog3Id){

        List<BaseAttrInfo> attrInfos = manageService.getBaseAttrInfo(catalog3Id);

        return attrInfos;
    }

    @PostMapping("saveAttrInfo")
    public String saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){

        manageService.saveAttrInfo(baseAttrInfo);

        return "success";
    }

    @PostMapping("getAttrValueList")
    public List<BaseAttrValue> getAttrValueList (String attrId){

        BaseAttrInfo pmsBaseInfo = manageService.getBaseInfo(attrId);

        return pmsBaseInfo.getAttrValueList();
    }

    @PostMapping("delAttrValue")
    public String delAttrValue(@RequestBody BaseAttrValue attrValue){

        manageService.delBaseAttrValue(attrValue);

        return "success";
    }

    @PostMapping("baseSaleAttrList")
    public List<BaseSaleAttr> getBaseSaleAttrList(){
        return manageService.getBaseSaleAttrList();
    }

    @PostMapping("saveSpuInfo")
    public String saveSpuInfo(@RequestBody SpuInfo spuInfo){
        manageService.saveSpuInfo(spuInfo);
        return "success";
    }

    @GetMapping("spuList")
    public List<SpuInfo> getSupList(String catalog3Id){
        List<SpuInfo> supList = manageService.getSupList(catalog3Id);
        return supList;
    }

    @GetMapping("spuImageList")
    public List<SpuImage> spuImageList(String spuId){
        List<SpuImage> spuImageList = manageService.getSpuImageList(spuId);
        return spuImageList;
    }

    @GetMapping("spuSaleAttrList")
    public List<SpuSaleAttr> spuSaleAttrList(String spuId){
        List<SpuSaleAttr> spuSaleAttrList = manageService.getSpuSaleAttrList(spuId);
        return spuSaleAttrList;
    }

    @PostMapping("saveSkuInfo")
    public String saveSkuInfo(@RequestBody SkuInfo skuInfo){
        manageService.saveSkuInfo(skuInfo);
        return "success";
    }

}
