package com.learn.gmall.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

// 保存平台属性
@Data
public class SkuAttrValue implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    @Column
    String attrId;

    @Column
    String valueId;

    @Column
    String skuId;

}
