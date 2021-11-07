package com.makunpeng.matrix.app.infra.persistence.post.d;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author MaKunPeng
 * @version 1.0
 * @date 2021/11/7
 * since
 **/
@Entity
@Table(name = "post_info")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostInfoDO {
    @Id
    private Long id;
    private Long pid;
    private Long uid;
    private String title;
    private String summary;
    private Timestamp ctime;
    private Timestamp mtime;
}
