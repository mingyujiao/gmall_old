package com.learn.gmall.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/11/12 22:02
 */
@Data
@NoArgsConstructor
public class PmsBaseAttrInfo implements Serializable {
    private static final long serialVersionUID = 3081208406423307824L;

    private String id;
    private String attrName;
    private String catalog3Id;
    private String isEnabled;

}
