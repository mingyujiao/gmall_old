package com.learn.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.learn.gmall.bean.*;
import com.learn.gmall.manage.mapper.*;
import com.learn.gmall.service.ManageService;
import org.apache.commons.lang3.StringUtils;
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
    PmsBaseCatalog1Mapper catalog1Mapper;

    @Autowired
    PmsBaseCatalog2Mapper catalog2Mapper;

    @Autowired
    PmsBaseCatalog3Mapper catalog3Mapper;

    @Autowired
    PmsBaseAttrInfoMapper attrInfoMapper;

    @Autowired
    PmsBaseAttrValueMapper attrValueMapper;

    @Override
    public List<PmsBaseCatalog1> getPmsBaseCatalog1() {
        return catalog1Mapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getPmsBaseCatalog2(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        List<PmsBaseCatalog2> pmsBaseCatalog2s = catalog2Mapper.select(pmsBaseCatalog2);
        return pmsBaseCatalog2s;
    }

    @Override
    public List<PmsBaseCatalog3> getPmsBaseCatalog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        List<PmsBaseCatalog3> pmsBaseCatalog3s = catalog3Mapper.select(pmsBaseCatalog3);
        return pmsBaseCatalog3s;
    }

    @Override
    public List<PmsBaseAttrInfo> getPmsBaseAttrInfo(String catalog3Id) {

        Example example = new Example(PmsBaseAttrInfo.class);

        example.createCriteria().andEqualTo("catalog3Id", catalog3Id);

        List<PmsBaseAttrInfo> pmsBaseAttrInfos = attrInfoMapper.selectByExample(example);

        return pmsBaseAttrInfos;
    }

    @Override
    @Transient
    public void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {

        if (StringUtils.isNotBlank(pmsBaseAttrInfo.getId())) {
            attrInfoMapper.updateByPrimaryKey(pmsBaseAttrInfo);
        } else {
            pmsBaseAttrInfo.setId(null);
            attrInfoMapper.insertSelective(pmsBaseAttrInfo);
        }

        String id = pmsBaseAttrInfo.getId();

        Example example = new Example(PmsBaseAttrValue.class);
        example.createCriteria().andEqualTo("attrId",id);
        attrInfoMapper.deleteByExample(example);

        for (PmsBaseAttrValue attrValue: pmsBaseAttrInfo.getAttrValueList()) {
            attrValue.setAttrId(id);
            attrValueMapper.insertSelective(attrValue);
        }

    }
}
