package com.learn.gmall.manage.mapper;

import com.learn.gmall.bean.SpuSaleAttr;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/12/5 23:51
 */
public interface SpuSaleAttrMapper extends Mapper<SpuSaleAttr> {

    public List<SpuSaleAttr> getSpuSaleAttrListBySpuId(String supId);
}
