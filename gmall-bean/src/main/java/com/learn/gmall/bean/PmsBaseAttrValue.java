package com.learn.gmall.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/11/12 22:02
 */
@Data
@NoArgsConstructor
public class PmsBaseAttrValue implements Serializable {
    private static final long serialVersionUID = -8041772194991485117L;
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String valueName;
    @Column
    private String attrId;
    @Column
    private String isEnabled;
}
