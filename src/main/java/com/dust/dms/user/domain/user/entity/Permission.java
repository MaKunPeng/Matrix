package com.dust.dms.user.domain.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 权限实体
 */
@Data
@Entity(name = "dms_per")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long parentId;
    private String code;
    private String name;
    /*
     * 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
     */
    private Integer type;
    private long resourceId;
    /*
     * 状态：0启用、1禁用
     */
    private int status;
}
