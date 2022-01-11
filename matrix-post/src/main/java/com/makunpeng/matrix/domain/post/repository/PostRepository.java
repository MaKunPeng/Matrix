package com.makunpeng.matrix.domain.post.repository;

import com.makunpeng.matrix.domain.post.aggregate.Post;

/**
 * Post 领域仓储服务接口
 * @author MaKunPeng
 * @version 1.0
 * @since 1.0
 **/
public interface PostRepository {
    Post findPost(Long pid);

    Post savePost(Post post);

    void deletePost(Long pid);
}
