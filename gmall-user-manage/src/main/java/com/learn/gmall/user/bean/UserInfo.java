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
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 2929714167349587316L;
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String loginName;
    @Column
    private String nickName;
    @Column
    private String passwd;
    @Column
    private String name;
    @Column
    private String phoneNum;
    @Column
    private String email;
    @Column
    private String headImg;
    @Column
    private String userLevel;

}
