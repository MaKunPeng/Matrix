package com.makunpeng.matrix.post.domain.post.aggregate;

import com.makunpeng.matrix.post.common.ddd.AggregateRoot;
import lombok.Data;

/**
 * Post 聚合根
 * @author Aaron Ma
 * @since 1.0
 */
@Data
public class Post implements AggregateRoot<PostInfoId> {
    private Long pid;
    private PostInfo postInfo;
    private PostBody postBody;
}
