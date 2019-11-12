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
public class PmsBaseAttrValue implements Serializable {
    private static final long serialVersionUID = -8041772194991485117L;

    private String id;
    private String valueName;
    private String attrId;
    private String isEnabled;
}
