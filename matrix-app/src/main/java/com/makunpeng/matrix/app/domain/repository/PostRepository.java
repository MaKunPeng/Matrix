package com.makunpeng.matrix.app.domain.repository;

import com.makunpeng.matrix.app.domain.model.post.Post;
import com.makunpeng.matrix.common.ddd.Repository;

import java.util.List;

/**
 * Post 领域数据服务接口
 * @author MaKunPeng
 * @date 2021-8-17
 */
public interface PostRepository extends Repository {
    Post findPost(Long uid);
}
