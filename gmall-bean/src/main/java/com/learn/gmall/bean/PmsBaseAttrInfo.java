package com.learn.gmall.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/11/12 22:02
 */
@Data
@NoArgsConstructor
public class PmsBaseAttrInfo implements Serializable {
    private static final long serialVersionUID = 3081208406423307824L;

    @Id
    @Column
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private String id;
    @Column
    private String attrName;
    @Column
    private String catalog3Id;
    @Column
    private String isEnabled;

    @Transient
    private List<PmsBaseAttrValue> attrValueList;

}
