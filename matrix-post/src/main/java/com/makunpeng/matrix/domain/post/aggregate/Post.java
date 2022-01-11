package com.makunpeng.matrix.domain.post.aggregate;

import com.makunpeng.matrix.common.ddd.AggregateRoot;
import com.makunpeng.matrix.domain.post.entity.PostBody;
import com.makunpeng.matrix.domain.post.entity.PostInfo;
import com.makunpeng.matrix.domain.post.entity.PostInfoId;
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
