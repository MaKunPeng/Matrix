package com.makunpeng.matrix.app.infra.persistence.sql.post;

import com.makunpeng.matrix.app.domain.model.post.Post;
import com.makunpeng.matrix.app.domain.model.post.PostBody;
import com.makunpeng.matrix.app.domain.model.post.PostId;
import org.springframework.stereotype.Component;

/**
 * Post 领域模型转换
 *
 * @author MaKunPeng
 */
@Component
public class PostDataConverter {
    public static final PostDataConverter INSTATNCE = new PostDataConverter();

    public Post toPost(PostInfoDO postInfoDO, PostBodyDO postBodyDO) {
        return new Post(new PostId(postInfoDO.getId()), postInfoDO.getPid(), postInfoDO.getUid(), postInfoDO.getTitle(), postInfoDO.getSummary(),
                new PostBody(postBodyDO.getId(), postBodyDO.getPid(), postBodyDO.getContent()),
                0, 0);
    }
}
