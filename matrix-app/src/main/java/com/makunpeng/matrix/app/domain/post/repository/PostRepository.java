package com.makunpeng.matrix.app.domain.post.repository;

import com.makunpeng.matrix.app.domain.model.post.Post;
import com.makunpeng.matrix.app.interfaces.post.query.PostInfoListQuery;
import com.makunpeng.matrix.app.interfaces.post.query.PostInfoSingleQuery;

import java.util.List;

/**
 * @author MaKunPeng
 * @version 1.0
 * @date 2021/11/7
 * @since
 **/
public interface PostRepository {
    Post find(PostInfoSingleQuery query);
    List<Post> listPost(PostInfoListQuery query);
}
