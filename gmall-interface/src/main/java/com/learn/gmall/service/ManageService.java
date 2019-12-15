package com.learn.gmall.service;

import com.learn.gmall.bean.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

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

    public List<SpuSaleAttr> getSpuSaleAttrList(String spuId);

    public void saveSkuInfo(SkuInfo skuInfo);

    /**
     * 查询skuinfo
     * @param skuId
     * @return
     */
    public SkuInfo getSkuInfo(String skuId);

    /**
     * 删除销售属性
     * @param attrId
     */
    public void deleteAttrInfoById(String attrId);

    /**
     * 删除spuId
     * @param spuId
     */
    public void delSpuById(String spuId);

    /**
     * 获取销售属性
     * @param skuId
     * @param spuId
     * @return
     */
    public List<SpuSaleAttr> selectSpuSaleAttrListCheckBySku(@Param("skuId") String skuId, @Param("spuId") String spuId);
}
