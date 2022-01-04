package com.makunpeng.matrix.app.domain.post.repository;

import com.makunpeng.matrix.app.domain.post.aggregate.Post;
import com.makunpeng.matrix.app.domain.post.aggregate.PostBody;
import com.makunpeng.matrix.app.domain.post.aggregate.PostInfo;
import com.makunpeng.matrix.app.interfaces.post.query.PostBodyQuery;
import com.makunpeng.matrix.app.interfaces.post.query.PostInfoSingleQuery;

/**
 * Post 领域仓储服务接口
 * @author MaKunPeng
 * @version 1.0
 * @since 1.0
 **/
public interface PostRepository {
    Post findPost(Long pid);

    Post savePost(Post post);
}
