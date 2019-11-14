package com.learn.gmall.service;

import com.learn.gmall.bean.*;

import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/11/10 23:06
 */
public interface ManageService {

    public List<PmsBaseCatalog1> getPmsBaseCatalog1();

    public List<PmsBaseCatalog2> getPmsBaseCatalog2(String catalog1Id);

    public List<PmsBaseCatalog3> getPmsBaseCatalog3(String catalog2Id);

    public List<PmsBaseAttrInfo> getPmsBaseAttrInfo(String catalog3Id);

    public void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    public PmsBaseAttrInfo getPmsBaseInfo(String atrrId);

    public void delPmsBaseAttrValue(PmsBaseAttrValue pmsBaseAttrValue);
}
