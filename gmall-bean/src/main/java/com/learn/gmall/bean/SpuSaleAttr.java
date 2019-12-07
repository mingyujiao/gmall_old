package com.learn.gmall.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
public class SpuSaleAttr implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id ;

    @Column
    String spuId;

    @Column
    String saleAttrId;

    @Column
    String saleAttrName;

    // 销售属性值集合
    @Transient
    List<SpuSaleAttrValue> spuSaleAttrValueList;

}
