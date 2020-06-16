package com.dust.dms.user.domain.user.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "dms_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String icon;
    private String phone;
    private String email;
    private String note;
    private Date createTime;
    private Date loginTime;
    private Integer status;
}
