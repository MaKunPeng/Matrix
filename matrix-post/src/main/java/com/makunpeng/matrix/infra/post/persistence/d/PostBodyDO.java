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
            strategy = "com.makunpeng.matrix.infra.shared.key.SnowflakeKeyJpaGenerator")
    private Long id;
    private Long pid;
    private String content;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp ctime;
    @UpdateTimestamp
    private Timestamp mtime;

    public PostBodyDO(Long id, Long pid, String content) {
        this.id = id;
        this.pid = pid;
        this.content = content;
    }
}
