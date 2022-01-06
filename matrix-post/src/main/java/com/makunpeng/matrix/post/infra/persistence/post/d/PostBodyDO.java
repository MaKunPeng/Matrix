package com.makunpeng.matrix.post.infra.persistence.post.d;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author MaKunPeng
 * @version 1.0
 * since
 **/
@Entity
@Table(name = "post_body")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostBodyDO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "snowflake")
    @GenericGenerator(name = "snowflake",
            strategy = "com.makunpeng.matrix.post.infra.persistence.key.SnowflakeKeyJpaGenerator")
    private Long id;
    private Long pid;
    private String content;
    @CreationTimestamp
    private Timestamp ctime;
    @UpdateTimestamp
    private Timestamp mtime;

    public PostBodyDO(Long id, Long pid, String content) {
        this.id = id;
        this.pid = pid;
        this.content = content;
    }
}
