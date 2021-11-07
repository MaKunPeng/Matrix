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
 * since
 **/
@Entity
@Table(name = "post_body")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostBodyDO {
    @Id
    private Long id;
    private Long pid;
    private String content;
    private Timestamp ctime;
    private Timestamp mtime;
}
