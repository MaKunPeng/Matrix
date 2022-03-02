package com.makunpeng.matrix.infra.post.persistence.d;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author MaKunPeng
 * @version 1.0
 **/
@Entity
@Table(name = "post_info")
@NoArgsConstructor
@AllArgsConstructor
@Data
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
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
    private Integer state;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<String> tags;
    @CreationTimestamp
    @Column(updatable = false)
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
