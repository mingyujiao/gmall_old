package com.learn.gmall.manage.mapper;

import com.learn.gmall.bean.SpuSaleAttr;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/12/5 23:51
 */
public interface SpuSaleAttrMapper extends Mapper<SpuSaleAttr> {

    public List<SpuSaleAttr> getSpuSaleAttrListBySpuId(String spuId);

    public List<SpuSaleAttr> selectSpuSaleAttrListCheckBySku(@Param("skuId") String skuId,@Param("spuId") String spuId);
}
