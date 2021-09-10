package com.makunpeng.matrix.app.domain.model.post;

import com.makunpeng.matrix.common.ddd.AggregateRoot;
import com.makunpeng.matrix.common.ddd.EntityState;
import lombok.*;

/**
 * Post 领域聚合根
 * @author MaKunPeng
 * @since 1.0
 * @date 2021/8/16
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Post implements AggregateRoot<PostId> {
    private PostId id;
    private PostDesc desc;
    private PostBody body;
    private Integer commentCounts;
    private Integer likesCounts;
    private EntityState state;
}
