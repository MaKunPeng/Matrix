package com.makunpeng.matrix.app.domain.post.aggregate;

import com.makunpeng.matrix.common.ddd.AggregateRoot;
import lombok.Data;

/**
 * Post 聚合根
 * @author Aaron Ma
 * @since 1.0
 */
@Data
public class Post implements AggregateRoot<PostInfoId> {
    private PostInfoId id;
    private PostInfo postInfo;
    private PostBody postBody;
}
