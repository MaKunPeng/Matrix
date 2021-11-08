package com.makunpeng.matrix.app.domain.post.repository;

import com.makunpeng.matrix.app.domain.post.aggregate.PostBodyA;
import com.makunpeng.matrix.app.domain.post.aggregate.PostInfoA;
import com.makunpeng.matrix.app.interfaces.post.query.PostBodyQuery;
import com.makunpeng.matrix.app.interfaces.post.query.PostInfoListQuery;
import com.makunpeng.matrix.app.interfaces.post.query.PostInfoSingleQuery;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author MaKunPeng
 * @version 1.0
 * @date 2021/11/7
 * @since
 **/
public interface PostRepository {
    PostInfoA findPostInfo(PostInfoSingleQuery query);
    Page<PostInfoA> listPostInfo(PostInfoListQuery query);
    PostBodyA findPostBody(PostBodyQuery query);
}
