package com.learn.gmall.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class SpuSaleAttrValue implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    @Column
    String spuId;

    @Column
    String saleAttrId;

    @Column
    String saleAttrValueName;
    // isChecked 什么用？ 当前的属性值是否被选中！
    @Transient
    String isChecked;

}

