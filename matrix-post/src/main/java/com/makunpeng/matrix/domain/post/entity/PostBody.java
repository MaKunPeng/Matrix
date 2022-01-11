package com.makunpeng.matrix.domain.post.entity;

import com.makunpeng.matrix.common.ddd.Entity;
import lombok.*;

import java.sql.Timestamp;

/**
 * 文章内容聚合
 * @author MaKunPeng
 * @version 1.0
 * @since 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostBody implements Entity<PostBodyId> {
    private PostBodyId postBodyId;
    private Long pid;
    private String content;
}
