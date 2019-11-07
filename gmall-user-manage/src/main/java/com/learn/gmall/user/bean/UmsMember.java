package com.learn.gmall.user.bean;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2019/11/7 23:54
 */
@Data
@NoArgsConstructor
public class UmsMember implements Serializable {
    private static final long serialVersionUID = 2929714167349587316L;
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer memberLevelId;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String nickname;
    @Column
    private String phone;
    @Column
    private Integer status;
    @Column
    private Date createTime;
    @Column
    private String icon;
    @Column
    private Integer gender;
    @Column
    private Date birthday;
    @Column
    private String city;
    @Column
    private String job;
    @Column
    private String personalizedSignature;
    @Column
    private Integer sourceType;
    @Column
    private Integer integration;
    @Column
    private Integer growth;
    @Column
    private Integer luckeyCount;
    @Column
    private Integer historyIntegration;
}
