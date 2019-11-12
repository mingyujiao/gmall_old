package com.learn.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.learn.gmall.bean.PmsBaseCatalog1;
import com.learn.gmall.bean.PmsBaseCatalog2;
import com.learn.gmall.bean.PmsBaseCatalog3;
import com.learn.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.learn.gmall.manage.mapper.PmsBaseCatalog2Mapper;
import com.learn.gmall.manage.mapper.PmsBaseCatalog3Mapper;
import com.learn.gmall.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;

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
}
