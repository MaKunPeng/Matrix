package com.makunpeng.matrix.post.domain.post.aggregate;

import com.makunpeng.matrix.post.common.ddd.Entity;
import lombok.*;

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
