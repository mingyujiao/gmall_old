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
    SpuInfoMapper spuInfoMapper;

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

        Example example = new Example(BaseAttrInfo.class);

        example.createCriteria().andEqualTo("catalog3Id", catalog3Id);

        List<BaseAttrInfo> baseAttrInfos = attrInfoMapper.selectByExample(example);

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
        example.createCriteria().andEqualTo("attrId",id);
        attrValueMapper.deleteByExample(example);

        for (BaseAttrValue attrValue: baseAttrInfo.getAttrValueList()) {
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
    public void delBaseAttrValue(@Param(value="id")BaseAttrValue pmsBaseAttrValue) {

        Example example = new Example(BaseAttrValue.class);
        example.createCriteria().andEqualTo("id",pmsBaseAttrValue.getId());

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

        for (SpuImage image: imageList) {
            image.setSpuId(spuInfo.getId());
            spuImageMapper.insertSelective(image);
        }

        List<SpuSaleAttr> spuSaleAttrs = spuInfo.getSpuSaleAttrList();

        for (SpuSaleAttr sale: spuSaleAttrs) {
            sale.setSpuId(spuInfo.getId());
            spuSaleAttrMapper.insertSelective(sale);

            List<SpuSaleAttrValue> spuSaleAttrValues = sale.getSpuSaleAttrValueList();

            for (SpuSaleAttrValue saleValue: spuSaleAttrValues) {
                saleValue.setSpuId(spuInfo.getId());
                saleValue.setSaleAttrId(sale.getId());
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


}
