package com.dust.dms.user.domain.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 角色模型
 *
 * @author MaKunPeng
 */
@Data
@Entity(name = "dms_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private String authorizer;

}
