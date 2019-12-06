package com.learn.gmall.service;

import com.learn.gmall.bean.*;

import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/11/10 23:06
 */
public interface ManageService {

    public List<BaseCatalog1> getBaseCatalog1();

    public List<BaseCatalog2> getBaseCatalog2(String catalog1Id);

    public List<BaseCatalog3> getBaseCatalog3(String catalog2Id);

    public List<BaseAttrInfo> getBaseAttrInfo(String catalog3Id);

    public void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    public BaseAttrInfo getBaseInfo(String atrrId);

    public void delBaseAttrValue(BaseAttrValue baseAttrValue);

    public List<BaseSaleAttr> getBaseSaleAttrList();

    public void saveSpuInfo(SpuInfo spuInfo);

    public List<SpuInfo> getSupList(String catalog3Id);

    public List<SpuImage> getSpuImageList(String spuId);
}
