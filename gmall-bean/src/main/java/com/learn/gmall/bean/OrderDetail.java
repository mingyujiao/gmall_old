package com.learn.gmall.bean;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderDetail implements Serializable{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String orderId;
    @Column
    private String skuId;
    @Column
    private String skuName;
    @Column
    private String imgUrl;
    @Column
    private BigDecimal orderPrice;
    @Column
    private Integer skuNum;

    // 表示是否有库存
    @Transient
    private String hasStock;

}
