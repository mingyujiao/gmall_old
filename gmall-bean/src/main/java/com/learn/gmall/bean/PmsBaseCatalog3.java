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
 * @date 2019/11/10 22:47
 */
@Data
@NoArgsConstructor
public class PmsBaseCatalog3 implements Serializable {
    private static final long serialVersionUID = -6926596654771853029L;

    @Id
    @Column
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private String id;

    @Column
    private String name;

    @Column
    private String catalog2Id;
}