package com.makunpeng.matrix.app.persistence.post;

import com.makunpeng.matrix.app.domain.model.post.Post;
import com.makunpeng.matrix.app.domain.model.post.PostId;
import org.springframework.stereotype.Component;

/**
 * Post 领域模型转换
 *
 * @author MaKunPeng
 */
@Component
public class PostBuilder {
    public Post toPost(PostInfoDO postInfoDO, PostBodyDO postBodyDO) {
        return new Post(new PostId(postInfoDO.getPid()), postInfoDO.getUid(), postInfoDO.getTitle(), postInfoDO.getSummary(),
                postBodyDO.getContent(), postInfoDO.getCommentCounts(), postInfoDO.getLikesCounts());
    }

    public PostInfoDO toPostInfo(Post post) {
        return new PostInfoDO(null, post.getPostId().getPid(), post.getUid(), post.getTitle(), post.getSummary(),
                post.getCommentCounts(), post.getLikesCounts(), null, null);
    }

    public PostBodyDO toPostBody(Post post) {
        return new PostBodyDO(null, post.getPostId().getPid(), post.getContent(), null, null);
    }
}
