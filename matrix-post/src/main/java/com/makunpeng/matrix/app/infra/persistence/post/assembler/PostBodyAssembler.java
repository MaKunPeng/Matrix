package com.makunpeng.matrix.app.infra.persistence.post.assembler;

import com.makunpeng.matrix.app.domain.post.aggregate.PostBody;
import com.makunpeng.matrix.app.domain.post.aggregate.PostBodyId;
import com.makunpeng.matrix.app.domain.post.aggregate.PostInfoId;
import com.makunpeng.matrix.app.infra.persistence.post.d.PostBodyDO;
import org.springframework.stereotype.Component;

/**
 * 文章内容转换
 * @author MaKunPeng
 * @version 1.0
 * since
 **/
@Component
public class PostBodyAssembler {
    public PostBody doToEntity(PostBodyDO postBodyDO) {
        return new PostBody(
                new PostBodyId(postBodyDO.getId()),
                new PostInfoId(postBodyDO.getPid()),
                postBodyDO.getContent());
    }

    public PostBodyDO entityToPostBodyDO(PostBody postBody) {
        return new PostBodyDO(
                postBody.getPostBodyId().getId(),
                postBody.getPostInfoId().getId(),
                postBody.getContent());
    }
}
