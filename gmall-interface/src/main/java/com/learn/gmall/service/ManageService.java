package com.learn.gmall.service;

import com.learn.gmall.bean.PmsBaseAttrInfo;
import com.learn.gmall.bean.PmsBaseCatalog1;
import com.learn.gmall.bean.PmsBaseCatalog2;
import com.learn.gmall.bean.PmsBaseCatalog3;

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
}
