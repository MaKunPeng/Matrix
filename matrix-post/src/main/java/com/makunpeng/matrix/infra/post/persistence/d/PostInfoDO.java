package com.makunpeng.matrix.infra.post.persistence.d;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "snowflake")
    @GenericGenerator(name = "snowflake",
            strategy = "com.makunpeng.matrix.infra.shared.key.SnowflakeKeyJpaGenerator")
    private Long id;
    private Long pid;
    private Long uid;
    private String title;
    private String summary;
    @CreationTimestamp
    private Timestamp ctime;
    @UpdateTimestamp
    private Timestamp mtime;

    public PostInfoDO(Long id, Long pid, Long uid, String title, String summary) {
        this.id = id;
        this.pid = pid;
        this.uid = uid;
        this.title = title;
        this.summary = summary;
    }
}
