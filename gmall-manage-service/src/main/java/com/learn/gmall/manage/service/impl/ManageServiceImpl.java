package com.learn.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.learn.gmall.bean.*;
import com.learn.gmall.manage.mapper.*;
import com.learn.gmall.service.ManageService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.beans.Transient;
import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/11/10 23:12
 */
@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    SkuImageMapper skuImageMapper;

    @Autowired
    SkuAttrValueMapper skuAttrValueMapper;

    @Autowired
    SkuSaleAttrValueMapper skuSaleAttrValueMapper;

    @Autowired
    SpuInfoMapper spuInfoMapper;

    @Autowired
    SkuInfoMapper skuInfoMapper;

    @Autowired
    BaseSaleAttrMapper baseSaleAttrMapper;

    @Autowired
    SpuImageMapper spuImageMapper;

    @Autowired
    SpuSaleAttrMapper spuSaleAttrMapper;

    @Autowired
    SpuSaleAttrValueMapper spuSaleAttrValueMapper;

    @Autowired
    BaseCatalog1Mapper catalog1Mapper;

    @Autowired
    BaseCatalog2Mapper catalog2Mapper;

    @Autowired
    BaseCatalog3Mapper catalog3Mapper;

    @Autowired
    BaseAttrInfoMapper attrInfoMapper;

    @Autowired
    BaseAttrValueMapper attrValueMapper;


    @Override
    public List<BaseCatalog1> getBaseCatalog1() {
        return catalog1Mapper.selectAll();
    }

    @Override
    public List<BaseCatalog2> getBaseCatalog2(String catalog1Id) {
        BaseCatalog2 pmsBaseCatalog2 = new BaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        List<BaseCatalog2> pmsBaseCatalog2s = catalog2Mapper.select(pmsBaseCatalog2);
        return pmsBaseCatalog2s;
    }

    @Override
    public List<BaseCatalog3> getBaseCatalog3(String catalog2Id) {
        BaseCatalog3 pmsBaseCatalog3 = new BaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        List<BaseCatalog3> pmsBaseCatalog3s = catalog3Mapper.select(pmsBaseCatalog3);
        return pmsBaseCatalog3s;
    }

    @Override
    public List<BaseAttrInfo> getBaseAttrInfo(String catalog3Id) {
        List<BaseAttrInfo> baseAttrInfos = attrInfoMapper.getBaseAttrInfoListByCatalog3Id(catalog3Id);
        return baseAttrInfos;
    }

    @Override
    @Transient
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {

        if (StringUtils.isNotBlank(baseAttrInfo.getId())) {
            attrInfoMapper.updateByPrimaryKey(baseAttrInfo);
        } else {
            baseAttrInfo.setId(null);
            attrInfoMapper.insertSelective(baseAttrInfo);
        }

        String id = baseAttrInfo.getId();

        Example example = new Example(BaseAttrValue.class);
        example.createCriteria().andEqualTo("attrId", id);
        attrValueMapper.deleteByExample(example);

        for (BaseAttrValue attrValue : baseAttrInfo.getAttrValueList()) {
            attrValue.setAttrId(id);
            attrValueMapper.insertSelective(attrValue);
        }

    }

    @Override
    public BaseAttrInfo getBaseInfo(String atrrId) {

        BaseAttrInfo pmsBaseAttrInfo = attrInfoMapper.selectByPrimaryKey(atrrId);

        BaseAttrValue attrValueQuery = new BaseAttrValue();
        attrValueQuery.setAttrId(atrrId);

        List<BaseAttrValue> attrValueList = attrValueMapper.select(attrValueQuery);

        pmsBaseAttrInfo.setAttrValueList(attrValueList);

        return pmsBaseAttrInfo;
    }

    @Override
    public void delBaseAttrValue(@Param(value = "id") BaseAttrValue pmsBaseAttrValue) {

        Example example = new Example(BaseAttrValue.class);
        example.createCriteria().andEqualTo("id", pmsBaseAttrValue.getId());

        attrValueMapper.deleteByExample(example);
    }

    @Override
    public List<BaseSaleAttr> getBaseSaleAttrList() {
        return baseSaleAttrMapper.selectAll();
    }

    @Override
    @Transient
    public void saveSpuInfo(SpuInfo spuInfo) {
        if (StringUtils.isNotBlank(spuInfo.getId())) {
            spuInfoMapper.updateByPrimaryKey(spuInfo);
        } else {
            spuInfo.setId(null);
            spuInfoMapper.insertSelective(spuInfo);
        }

        List<SpuImage> imageList = spuInfo.getSpuImageList();

        for (SpuImage image : imageList) {
            image.setSpuId(spuInfo.getId());
            spuImageMapper.insertSelective(image);
        }

        List<SpuSaleAttr> spuSaleAttrs = spuInfo.getSpuSaleAttrList();

        for (SpuSaleAttr sale : spuSaleAttrs) {
            sale.setSpuId(spuInfo.getId());
            spuSaleAttrMapper.insertSelective(sale);

            List<SpuSaleAttrValue> spuSaleAttrValues = sale.getSpuSaleAttrValueList();

            for (SpuSaleAttrValue saleValue : spuSaleAttrValues) {
                saleValue.setSpuId(spuInfo.getId());
                spuSaleAttrValueMapper.insertSelective(saleValue);
            }
        }
    }

    @Override
    public List<SpuInfo> getSupList(String catalog3Id) {
        SpuInfo spuInfo = new SpuInfo();
        spuInfo.setCatalog3Id(catalog3Id);
        return spuInfoMapper.select(spuInfo);
    }

    @Override
    public List<SpuImage> getSpuImageList(String spuId) {
        SpuImage spuImage = new SpuImage();
        spuImage.setSpuId(spuId);
        return spuImageMapper.select(spuImage);
    }

    @Override
    public List<SpuSaleAttr> getSpuSaleAttrList(String spuId) {
        return spuSaleAttrMapper.getSpuSaleAttrListBySpuId(spuId);
    }

    @Override
    public void saveSkuInfo(SkuInfo skuInfo) {
        if (StringUtils.isNotBlank(skuInfo.getId())) {
            skuInfoMapper.updateByPrimaryKey(skuInfo);
        } else {
            skuInfo.setId(null);
            skuInfoMapper.insert(skuInfo);
        }

        List<SkuImage> skuImageList = skuInfo.getSkuImageList();

        for (SkuImage skuImage : skuImageList) {
            skuImage.setSkuId(skuInfo.getId());
            skuImageMapper.insert(skuImage);
        }

        List<SkuAttrValue> skuAttrValueList = skuInfo.getSkuAttrValueList();

        for (SkuAttrValue skuAttrValue : skuAttrValueList) {
            skuAttrValue.setSkuId(skuInfo.getId());
            skuAttrValueMapper.insert(skuAttrValue);
        }

        List<SkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();

        for (SkuSaleAttrValue skuSaleAttrValue : skuSaleAttrValueList) {
            skuSaleAttrValue.setSkuId(skuInfo.getId());
            skuSaleAttrValueMapper.insert(skuSaleAttrValue);
        }
    }

    @Override
    public SkuInfo getSkuInfo(String skuId) {
        SkuInfo skuInfo = skuInfoMapper.selectByPrimaryKey(skuId);

        if (skuInfo != null) {
            SkuImage skuImage = new SkuImage();
            skuImage.setSkuId(skuId);

            List<SkuImage> skuImages = skuImageMapper.select(skuImage);
            skuInfo.setSkuImageList(skuImages);

            SkuAttrValue SkuAttrValue = new SkuAttrValue();
            SkuAttrValue.setSkuId(skuId);
            List<SkuAttrValue> SkuAttrValues = skuAttrValueMapper.select(SkuAttrValue);
            skuInfo.setSkuAttrValueList(SkuAttrValues);
        }

        return skuInfo;
    }


}
