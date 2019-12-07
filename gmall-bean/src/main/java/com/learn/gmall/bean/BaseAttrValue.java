package com.learn.gmall.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class BaseAttrValue implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String valueName;
    @Column
    private String attrId;

    // 声明一个变量
    @Transient
    private String urlParam;


}
