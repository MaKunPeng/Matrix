package com.makunpeng.matrix.app.infra.persistence.post.d;

import lombok.*;

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
@Setter
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

    public PostInfoDO(Long id, Long pid, Long uid, String title, String summary) {
        this.id = id;
        this.pid = pid;
        this.uid = uid;
        this.title = title;
        this.summary = summary;
    }
}
