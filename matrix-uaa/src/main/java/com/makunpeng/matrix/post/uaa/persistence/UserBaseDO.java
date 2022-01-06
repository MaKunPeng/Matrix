package com.makunpeng.matrix.post.uaa.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "post_info")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserBaseDO {
    @Id
    private Long id;
    private Long uid;
    private String name;
    private Integer sex;
    private Integer accountState;
    private Timestamp ctime;
    private Timestamp mtime;
}
